package com.example.calculator1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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
        assertEquals(4294967294l, result);
    }

    @Test
    void plus_num1MinPlusNum2Min_result() {
        var result = underTest.plus(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(-4294967296l, result);
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
        assertEquals(4611686014132420609l, result);
    }

    @Test
    void multiply_num1MinPlusNum2Min_resultLong() {
        var result = underTest.multiply(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(4611686018427387904l, result);
    }

    @Test
    void multiply_num1PlusNum2_result() {
        var result = underTest.multiply(3, 2);
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
        assertThrows(IllegalArgumentException.class, () -> underTest.divide(1, 0));
    }

    @ParameterizedTest
    @MethodSource("dataForPlus")
    void plus__returnLong(int num1, int num2, long expectedResult) {
        var result = underTest.plus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForPlus() {
        return Stream.of(
                Arguments.of(4, 1, 5),
                Arguments.of(6, -1, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMinus")
    void Minus__returnLong(int num1, int num2, long expectedResult) {
        var result = underTest.minus(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMinus() {
        return Stream.of(
                Arguments.of(4, 1, 3),
                Arguments.of(6, -1, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMultiply")
    void multiply__returnLong(int num1, int num2, long expectedResult) {
        var result = underTest.multiply(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForMultiply() {
        return Stream.of(
                Arguments.of(4, 1, 4),
                Arguments.of(6, -1, -6)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDivide")
    void divide__returnDouble(int num1, int num2, double expectedResult) {
        var result = underTest.divide(num1, num2);
        assertEquals(expectedResult, result);
    }

    private static Stream<Arguments> dataForDivide() {
        return Stream.of(
                Arguments.of(4, 2, 2),
                Arguments.of(5, 2, 2.5)
        );
    }

}