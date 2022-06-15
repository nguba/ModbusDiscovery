package org.example;

import com.ghgande.j2mod.modbus.procimg.*;

public class PxuProcessImage extends AbstractProcessImage {

    public static final int REG_PV = 1;
    public static final int REG_SP = 2;
    public static final int REG_SP1 = 3;
    public static final int REG_SP2 = 4;
    public static final int REG_DEV = 5;

    public PxuProcessImage() {
        super();
        createSimpleRegister(REG_PV);
        createSimpleRegister(REG_SP);
        createSimpleRegister(REG_SP1);
        createSimpleRegister(REG_SP2);
        createSimpleRegister(REG_DEV);
    }

    private void createSimpleRegister(final int ref) {
        image.addRegister(ref, new SimpleRegister(0));
    }

    public void setProcessValue(final int value) {
        getRegister(REG_PV).setValue(value);
    }

    public int getProcessValue() {
       return getRegister(PxuProcessImage.REG_PV).getValue();
    }
}
