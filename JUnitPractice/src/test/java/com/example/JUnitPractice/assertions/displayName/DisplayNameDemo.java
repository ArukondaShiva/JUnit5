package com.example.JUnitPractice.assertions.displayName;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Display Name Annotation Demo <\uD83E\uDDD8\u200D♀\uFE0F>")
public class DisplayNameDemo {

    @Test
    @DisplayName("Display Name test \uD83D\uDD75\uFE0F\u200D♀\uFE0F")
    public void displayNameTest(){
        assertEquals(3,2+1);
    }

    @Test
    @DisplayName("Display Name with spaces <\uD83D\uDD75\uFE0F\u200D♀\uFE0F>")
    public void displayNameTestWithSpaces(){
        assertEquals(3,2+1);
    }

    @Test
    @DisplayName("Display Name <!@#$#@!> special characters <\uD83D\uDD75\uFE0F\u200D♀\uFE0F>")
    public void displayNameTestSpecialCharacters(){
        assertEquals(3,2+1);
    }



}

