package com.gl.userManagementApp;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    SimpleCalculator simpleCalculator = new SimpleCalculator();

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals(simpleCalculator.add(1,2), 3);
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        assertEquals(simpleCalculator.subtract(1, 2), -1);

    }

    @org.junit.jupiter.api.Test
    void multiply() {
        assertEquals(simpleCalculator.multiply(1, 2), 2);
    }

    @org.junit.jupiter.api.Test
    void divide() {
        assertEquals(simpleCalculator.divide(1, 2), 0.5);
    }

    @org.junit.jupiter.api.Test
    void divideByZero() {
        assertThrows(ArithmeticException.class, () -> simpleCalculator.divide(1, 0));
    }

    //test case for divide when numbers are negative
    @org.junit.jupiter.api.Test
    void divideByZeroNegative() {
        assertThrows(ArithmeticException.class, () -> simpleCalculator.divide(-1, 0));
    }

}