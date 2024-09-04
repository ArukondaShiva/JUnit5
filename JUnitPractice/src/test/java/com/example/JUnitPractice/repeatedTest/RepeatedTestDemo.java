package com.example.JUnitPractice.repeatedTest;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RepeatedTestDemo {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("@BeforeAll got executed");
    }

    public RepeatedTestDemo(){
        System.out.println("Constructor got executed");
    }

    @BeforeEach
    public void beforeEach(){
        System.out.println(" @BeforeEach got executed");
    }



    @RepeatedTest(5)
    public void simpleRepeatedTest(){
        assertTrue(0<5);
    }

    @AfterEach
    public void afterEach(){
        System.out.println("@AfterEach got executed");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("@AfterAll got executed");
    }


}