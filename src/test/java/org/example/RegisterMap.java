package org.example;

import com.ghgande.j2mod.modbus.procimg.SimpleRegister;

import java.util.Map;
import java.util.TreeMap;

public class RegisterMap {

    public static final Integer PROCESS_VALUE = 1;

    private Map<Integer, SimpleRegister> registers;

    public RegisterMap(final Map<Integer, SimpleRegister> registers) {
        this.registers = registers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public SimpleRegister getProcessValueRegister() {
        return registers.get(getProcessValueIndex());
    }

    public Integer getProcessValueIndex() {
        return Integer.valueOf(PROCESS_VALUE);
    }

    public static class Builder {
        Map<Integer, SimpleRegister> registers = new TreeMap<>();

        public Builder addProcessValue(final int value) {
            registers.put(PROCESS_VALUE, new SimpleRegister(value));
            return this;
        }

        public RegisterMap build() {
            return new RegisterMap(registers);
        }
    }
}
