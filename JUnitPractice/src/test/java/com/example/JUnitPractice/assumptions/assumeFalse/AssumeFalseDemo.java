package com.example.JUnitPractice.assumptions.assumeFalse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

public class AssumeFalseDemo {

    @Test
    public void assumeFalseWithNoMessage() {
        assumeFalse("DEV".equals(System.getProperty("ENV")));

        System.out.println("Assumption passed !!!");
        assertEquals(3, 2 + 1);
    }

    @Test
    public void assumeFalseWithMessage() {
        assumeFalse("DEV".equals(System.getProperty("ENV")), "Assumption Failed !!!");

        System.out.println("Assumption passed !!!");
        assertEquals(3, 2 + 1);
    }

    @Test
    public void assumeFalseWithMessageSupplier() {
        assumeFalse("DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed !!!");

        System.out.println("Assumption passed !!!");
        assertEquals(3, 2 + 1);
    }

    @Test
    public void assumeFalseWithBooleanSupplierAndNoMessage() {
        assumeFalse(() -> "DEV".equals(System.getProperty("ENV")));

        System.out.println("Assumption passed !!!");
        assertEquals(3, 2 + 1);
    }

    @Test
    public void assumeFalseWithBooleanSupplierAndMessage() {
        assumeFalse(() -> "DEV".equals(System.getProperty("ENV")), "Assumption Failed !!!");

        System.out.println("Assumption passed !!!");
        assertEquals(3, 2 + 1);
    }

    @Test
    public void assumeFalseWithBooleanSupplierAndMessageSupplier() {
        assumeFalse(() -> "DEV".equals(System.getProperty("ENV")), () -> "Assumption Failed !!!");

        System.out.println("Assumption passed !!!");
        assertEquals(3, 2 + 1);
    }


}
