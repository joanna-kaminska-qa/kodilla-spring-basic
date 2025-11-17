package com.kodilla.spring.basic.spring_dependency_injection.homework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorTestSuite {

    @Autowired
    Calculator calculator;

    double a;
    double b;
    double c;

    @BeforeEach
    public void setUp() {
        a = 10.0;
        b = 5.0;
        c = 0.0;
    }

    @Test
    public void shouldReturnCorrectSum() {
        double result = calculator.add(a, b);
        assertEquals(result, 15.0, 0000.1);
    }

    @Test
    public void shouldReturnCorrectSubtract() {
        double result = calculator.subtract(a, b);
        assertEquals(result, 5.0, 0000.1);
    }

    @Test
    public void shouldMultiplyCorrectly() {
        double result = calculator.multiply(a, b);
        assertEquals(result, 50.0, 0000.1);
    }

    @Test
    public void shouldDivideCorrectly() {
        double result = calculator.divide(a, b);
        assertEquals(result, 2.0, 0000.1);
    }

    @Test
    public void shouldNOTDivideBy0() {
        assertThrows(ArithmeticException.class, () -> {
            calculator.divide(a, c);
        });
    }
}