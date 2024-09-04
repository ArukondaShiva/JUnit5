package com.example.JUnitPractice.parameterizedTest.valueSource;

import com.example.JUnitPractice.example.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValueSourceDemo {


    @Test
    public void testEvenValues(){
        Calculator calculator = new Calculator();
        assertTrue(calculator.isEvenNumber(2));
        assertTrue(calculator.isEvenNumber(4));
        assertTrue(calculator.isEvenNumber(6));
        assertTrue(calculator.isEvenNumber(8));
        assertTrue(calculator.isEvenNumber(10));
        assertTrue(calculator.isEvenNumber(12));
    }



    @ParameterizedTest
    @ValueSource(ints = {2,4,6,8})
    public void testEvenValuesUsingParameterizedTest(int number){
        Calculator calculator = new Calculator();
        assertTrue(calculator.isEvenNumber(number));
    }


}
