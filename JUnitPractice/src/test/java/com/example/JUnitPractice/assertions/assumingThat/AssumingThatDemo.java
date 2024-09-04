package com.example.JUnitPractice.assertions.assumingThat;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AssumingThatDemo {

    @Test
    public void assumingThatWithBooleanCondition(){

        //if boolean is true, then it executes the executable
        assumingThat("DEV".equals(System.getProperty("ENV")), ()->{
            System.out.println("Dev Environment !!");
            assertEquals(5,3+2);
        });

        // this block of code executes in all scenarios.
        System.out.println("Executed in every Environment");
        assertEquals(3,2+1);
    }


    @Test
    public void assumingThatWithBooleanSupplier(){

        //if boolean is true, then it executes the executable
        assumingThat(()-> "DEV".equals(System.getProperty("ENV")), ()->{
            System.out.println("Dev Environment !!");
            assertEquals(5,3+2);
        });

        // this block of code executes in all scenarios.
        System.out.println("Executed in every Environment");
        assertEquals(3,2+1);
    }


}