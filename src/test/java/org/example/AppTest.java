package org.example;

import com.ghgande.j2mod.modbus.facade.ModbusTCPMaster;
import com.ghgande.j2mod.modbus.procimg.*;
import com.ghgande.j2mod.modbus.slave.ModbusSlave;
import com.ghgande.j2mod.modbus.slave.ModbusSlaveFactory;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Unit test for simple App.
 */
class AppTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    void shouldAnswerWithTrue() throws Exception {
        SimpleProcessImage image = (SimpleProcessImage) new DefaultProcessImageFactory().createProcessImageImplementation();
        RegisterMap registers = new RegisterMap();
        for(Map.Entry<Integer, SimpleRegister> register : registers.getRegisters().entrySet()) {
            image.addRegister(register.getKey(), register.getValue());
        }

        image.addRegister(registers.getRegisters().size() + 1, new SimpleRegister(666));

        ModbusSlave slave = ModbusSlaveFactory.createTCPSlave(3030, 5);
        slave.addProcessImage(2, image);
        slave.open();
        try {
            // System.out.println(slave.getType());
            ModbusTCPMaster master = new ModbusTCPMaster("localhost", 3030);
            master.connect();

            // TODO consider a READER for this (to reduce complexity for reading specific values)
            // NOTE that we could use a Builder for the read request, and then read only up to the highest position to
            // reduce the size of the request and the returned to the absolute minimum.
            for (Register register : master.readMultipleRegisters(2, 1, 6)) {
                System.out.println(register);
            }
            master.disconnect();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            slave.close();
        }
    }

    // TODO consider a BUILDER pattern for this
    private static class RegisterMap {
        private final Map<Integer, SimpleRegister> registers = new HashMap<>();

        public RegisterMap() {
            registers.put(1, new SimpleRegister(500)); // pv
            registers.put(2, new SimpleRegister(485)); // sp
            registers.put(3, new SimpleRegister(0)); // sp1
            registers.put(4, new SimpleRegister(0)); // sp2
            registers.put(5, new SimpleRegister(500 - 485)); // setpoint deviation
        }

        public Map<Integer, SimpleRegister> getRegisters() {
            return Collections.unmodifiableMap(registers);
        }
    }

}
