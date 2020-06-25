package com.anton.day4_1.service;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ArithmeticServiceTest {
    ArithmeticService service;

    @BeforeClass
    public void setup() {
        service = new ArithmeticService();
    }

    @Test
    public void isSimpleNumberValidTest() {
        int numberToCheck = 5;
        boolean flag = service.isSimpleNumber(numberToCheck);
        assertTrue(flag);
    }

    @Test
    public void isSimpleNumberInvalidTest() {
        int numberToCheck = 6;
        boolean flag = service.isSimpleNumber(numberToCheck);
        assertFalse(flag);
    }

    @Test
    public void isFibonacciNumberValidTest() {
        int numberToCheck = 34;
        boolean flag = service.isFibonacciNumber(numberToCheck);
        assertTrue(flag);
    }

    @Test
    public void isFibonacciNumberInvalidTest() {
        int numberToCheck = 35;
        boolean flag = service.isFibonacciNumber(numberToCheck);
        assertFalse(flag);
    }

    @Test
    public void hasThreeDifferentDigitsValidTest() {
        int numberToCheck = 134;
        boolean flag = service.hasThreeDifferentDigits(numberToCheck);
        assertTrue(flag);
    }

    @DataProvider(name = "invalidThreeDigitNumber")
    public Object[][] createInvalidThreeDigitNumber() {
        return new Object[][] {
                {133}, {12}, {12345}
        };
    }

    @Test(dataProvider = "invalidThreeDigitNumber")
    public void hasThreeDifferentDigitsInvalidTest(int number) {
        boolean flag = service.hasThreeDifferentDigits(number);
        assertFalse(flag);
    }
}
