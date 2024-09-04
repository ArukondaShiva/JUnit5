package com.example.JUnitPractice.parameterizedTest.enumSource;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnumSourceDemo {

    @ParameterizedTest
    @EnumSource(value = Animal.class)
    public void enumSourceDemoTest(Animal animal){
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class, names = {"DOG","CAT"})
    public void enumSourceDemoWithNamesTest(Animal animal){
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class,  mode = EnumSource.Mode.EXCLUDE, names = {"DOG","CAT"})
    public void enumSourceDemoWithExcludeModeTest(Animal animal){
        assertNotNull(animal);
    }

    @ParameterizedTest
    @EnumSource(value = Animal.class,  mode = EnumSource.Mode.MATCH_ALL, names = "^(C|L).+$")
    public void enumSourceDemoWithExcludeWithMatchAllModeTest(Animal animal){
        assertNotNull(animal);
    }

}
