package com.anton.day4_1.validator;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NumberValidatorTest {
    NumberValidator validator;

    @BeforeClass
    public void setup() {
        validator = new NumberValidator();
    }

    @Test
    public void validateStringToIntArrValidTest() {
        String stringOfNumbers = "1 2 3 4 5";
        boolean flag = validator.validateStringToIntArr(stringOfNumbers);
        assertTrue(flag);
    }

    @DataProvider(name = "invalidIntArr")
    public static Object[][] createInvalidIntArr() {
        return new Object[][]{
                {"1 2 3 f"}, {null}, {"11111111111111111111111111 2222222222222222222222222222222"}
        };
    }

    @Test(dataProvider = "invalidIntArr")
    public void validateStringToIntArrInvalidTest(String numbers) {
        boolean flag = validator.validateStringToIntArr(numbers);
        assertFalse(flag);
    }

    @Test
    public void validatePositiveNumber() {
        String positiveNumber = "13";
        boolean flag = validator.validatePositiveNumber(positiveNumber);
        assertTrue(flag);
    }

    @DataProvider(name = "invalidPositiveInt")
    public static Object[][] createInvalidPositiveInt() {
        return new Object[][]{
                {"f"}, {null}, {"11111111111111111111111111"}, {"-1"}, {""}
        };
    }

    @Test(dataProvider = "invalidPositiveInt")
    public void validatePositiveNumberInvalidTest(String number) {
        boolean flag = validator.validatePositiveNumber(number);
        assertFalse(flag);
    }

    @Test
    public void validateNumberValidTest() {
        String positiveNumber = "13";
        boolean flag = validator.validatePositiveNumber(positiveNumber);
        assertTrue(flag);
    }

    @DataProvider(name = "invalidInt")
    public static Object[][] createInvalidInt() {
        return new Object[][]{
                {"f"}, {null}, {"11111111111111111111111111"}, {""}
        };
    }

    @Test(dataProvider = "invalidInt")
    public void validateNumberInvalidTest(String number) {
        boolean flag = validator.validateNumber(number);
        assertFalse(flag);
    }
}
