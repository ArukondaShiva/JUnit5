package com.example.JUnitPractice.dynamicTest;

import com.example.JUnitPractice.example.StringHelper;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestDemo {

    StringHelper stringHelper = new StringHelper();


    @TestFactory
    public DynamicTest testReverse(){

        return dynamicTest("Dynamic Test for reverse method",()->{
            assertEquals("god",stringHelper.reverse("dog"));
        });

    }


    /*
    @TestFactory
    public String testReverseWithString(){
        return "dynamic test";
    }
     */


    @TestFactory
    public Collection<DynamicTest> dynamicTestsFromCollection(){
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0;i<inputList.size();i++){
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse method", ()->{
                assertEquals(output, stringHelper.reverse(input));
            });

            dynamicTests.add(dynamicTest);
        }

        return dynamicTests;
    }



    @TestFactory
    public Iterable<DynamicTest> dynamicTestsFromIterable(){
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0;i<inputList.size();i++){
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse method", ()->{
                assertEquals(output, stringHelper.reverse(input));
            });

            dynamicTests.add(dynamicTest);
        }

        return dynamicTests;
    }



    @TestFactory
    public Iterator<DynamicTest> dynamicTestsFromIterator(){
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0;i<inputList.size();i++){
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse method", ()->{
                assertEquals(output, stringHelper.reverse(input));
            });

            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.iterator();
    }


    @TestFactory
    public Stream<DynamicTest> dynamicTestsFromStream(){
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0;i<inputList.size();i++){
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse method", ()->{
                assertEquals(output, stringHelper.reverse(input));
            });

            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.stream();
    }



    @TestFactory
    public DynamicTest[] dynamicTestsFromArray(){
        List<String> inputList = createInputList();
        List<String> outputList = createOutputList();

        Collection<DynamicTest> dynamicTests = new ArrayList<>();

        for(int i=0;i<inputList.size();i++){
            String input = inputList.get(i);
            String output = outputList.get(i);

            DynamicTest dynamicTest = dynamicTest("Dynamic Test for reverse method", ()->{
                assertEquals(output, stringHelper.reverse(input));
            });

            dynamicTests.add(dynamicTest);
        }

        return dynamicTests.toArray(new DynamicTest[dynamicTests.size()]);
    }


    @TestFactory
    public Stream<DynamicNode> dynamicTestWithDynamicContainers(){

        return createInputList().stream()
                .map(input ->
                        dynamicContainer("Container for "+ input, Stream.of(

                                dynamicTest("not null", ()-> assertNotNull(input)),

                                dynamicContainer("properties test", Stream.of(
                                        dynamicTest("length > 0",()->assertTrue(input.length()>0)),
                                        dynamicTest("length > 0",()->assertFalse(input.isEmpty()))
                                ))

                        ))
                );

    }


    private List<String> createOutputList() {
        return Arrays.asList("ecar","mom","dad");
    }

    private List<String> createInputList() {
        return Arrays.asList("race","mom","dad");
    }


}
