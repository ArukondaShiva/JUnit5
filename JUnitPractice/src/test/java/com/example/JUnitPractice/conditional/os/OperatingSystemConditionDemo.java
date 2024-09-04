package com.example.JUnitPractice.conditional.os;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OperatingSystemConditionDemo {

    @Test
    @EnabledOnOs(value = OS.WINDOWS)
    public void enableOnWindows(){
        System.out.println("Only execute on windows");
    }

    @Test
    @EnabledOnOs(value = OS.MAC)
    public void enableOnMac(){
        System.out.println("Only execute on mac");
    }


    @Test
    @EnabledOnOs(value = {OS.WINDOWS, OS.MAC})
    public void enableOnWindowsAndMac(){
        System.out.println("executes on windows and mac");
    }

    @Test
    @DisabledOnOs(value = OS.MAC)
    public void disableOnMac(){
        System.out.println("Only disable on Mac!!");
    }

    @Test
    @DisabledOnOs(value = OS.WINDOWS)
    public void disableOnOs(){
        System.out.println("Only disable on windows!!");
    }

}
