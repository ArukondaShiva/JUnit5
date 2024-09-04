package com.example.JUnitPractice.conditional.jre;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JavaRuntimeEnvironmentConditionsDemo {

    @Test
    @EnabledOnJre(value = JRE.JAVA_8)
    public void enableOnJava8(){

        System.out.println("Enable on JRE 8 !!!");

    }


    @Test
    @DisabledOnJre(value = JRE.JAVA_8)
    public void disableOnJava8(){

        System.out.println("Enable on JRE 8 !!!");

    }


    @Test
    @EnabledOnJre(value = {JRE.JAVA_8,JRE.JAVA_10})
    public void enableOnJava8And10(){

        System.out.println("Enable on JRE 8 And JRE 10 !!!");

    }

}
