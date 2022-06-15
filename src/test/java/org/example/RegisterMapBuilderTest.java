package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterMapBuilderTest {

    @Test
    void makeInstance() {
        assertNotNull(RegisterMap.builder());
    }

    @Test
    void addProcessValue() {
        RegisterMap.Builder builder = RegisterMap.builder().addProcessValue(225);

        assertEquals(builder.build().getProcessValueIndex(), Integer.valueOf(1));
    }
}