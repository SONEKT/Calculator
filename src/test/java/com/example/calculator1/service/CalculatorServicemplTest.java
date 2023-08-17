package com.example.calculator1.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServicemplTest {

    CalculatorService underTest = new CalculatorServicempl();

    @Test
    void welcome__returnWelcomeString() {
        String result = underTest.welcome();
        assertEquals("Добро пожаловать в калькулятор", result);
    }

    @Test
    void plus_num1MaxPlusNum2Max_resultLong() {
        var result = underTest.plus(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(-2, result);
    }

    @Test
    void plus_num1MinPlusNum2Min_result() {
        var result = underTest.plus(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(0, result);
    }

    @Test
    void plus_num1PlusNum2_result() {
        var result = underTest.plus(3, 2);
        assertEquals(5, result);
    }

    @Test
    void minus_num1BiggerPlusNum2Smaller_result() {
        var result = underTest.minus(3, 2);
        assertEquals(1, result);
    }

    @Test
    void minus_num1SmallerPlusNum2Bigger_result() {
        var result = underTest.minus(2, 3);
        assertEquals(-1, result);
    }

    @Test
    void multiply_num1MaxPlusNum2Max_resultLong() {
        var result = underTest.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(1, result);
    }

    @Test
    void multiply_num1MinPlusNum2Min_resultLong() {
        var result = underTest.multiply(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(0, result);
    }

    @Test
    void multiply_num1PlusNum2_result() {
        var result = underTest.multiply(3,2);
        assertEquals(6, result);
    }



    @Test
    void divide_num1DividedNum2WithoutFraction_resultWithoutFraction() {
        var result = underTest.divide(4, 2);
        assertEquals(2, result);
    }

    @Test
    void divide_num1DividedNum2WitFraction_resultWithFraction() {
        var result = underTest.divide(5, 2);
        assertEquals(2.5, result);
    }

    @Test
    void divide_num2Is0_throwIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()->underTest.divide(1, 0));
    }
}