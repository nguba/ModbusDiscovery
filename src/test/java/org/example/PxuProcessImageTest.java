package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PxuProcessImageTest {

    PxuProcessImage image = new PxuProcessImage();

    @Test
    void hasProcessValue() {
        assertEquals(image.getRegister(PxuProcessImage.REG_PV).getValue(), 0);
    }

    @Test
    void canSetProcessValue() {
        int expected = 555;
        image.setProcessValue(expected);

        assertEquals(image.getProcessValue(), expected);
    }

    @Test
    void hasActiveSetpoint() {
        assertEquals(image.getRegister(PxuProcessImage.REG_SP).getValue(), 0);
    }

    @Test
    void canSetSetpoint() {
        int expected = 555;
        image.setSetpoint(expected);

        assertEquals(image.getSetpoint( ), expected);
    }

    @Test
    void hasSp1() {
        assertEquals(image.getRegister(PxuProcessImage.REG_SP1).getValue(), 0);
    }

    @Test
    void hasSp2() {
        assertEquals(image.getRegister(PxuProcessImage.REG_SP2).getValue(), 0);
    }

    @Test
    void hasDeviation() {
        assertEquals(image.getRegister(PxuProcessImage.REG_DEV).getValue(), 0);
    }
}