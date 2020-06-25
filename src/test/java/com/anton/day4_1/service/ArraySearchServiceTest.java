package com.anton.day4_1.service;

import com.anton.day4_1.entity.CustomArray;
import com.anton.day4_1.exception.ProgramException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySearchServiceTest {
    ArraySearchService service;

    @BeforeClass
    public void setup() {
        service = new ArraySearchService();
    }

    @Test
    public void findMinValueValidTest() {
        try {
            int[] arr = {1, 2, 3, -1};
            CustomArray customArray = new CustomArray(arr);
            int expectedMinValue = service.findMinValue(customArray);
            int actualMinValue = -1;
            assertEquals(expectedMinValue, actualMinValue);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void findMinValueInvalidTest() {
        try {
            int[] arr = {1, 2, 3, -1};
            CustomArray customArray = new CustomArray(arr);
            int expectedMinValue = service.findMinValue(customArray);
            int notActualMinValue = 1;
            assertNotEquals(expectedMinValue, notActualMinValue);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void findMinValueExceptionTest() throws ProgramException {
        service.findMinValue(null);
    }

    @Test
    public void findMaxValueValidTest() {
        try {
            int[] arr = {1, 2, 3, -1};
            CustomArray customArray = new CustomArray(arr);
            int expectedMaxValue = service.findMaxValue(customArray);
            int actualMaxValue = 3;
            assertEquals(expectedMaxValue, actualMaxValue);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void findMaxValueInvalidTest() {
        try {
            int[] arr = {1, 2, 3, -1};
            CustomArray customArray = new CustomArray(arr);
            int expectedMaxValue = service.findMaxValue(customArray);
            int notActualMaxValue = 1;
            assertNotEquals(expectedMaxValue, notActualMaxValue);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void findMaxValueExceptionTest() throws ProgramException {
        service.findMaxValue(null);
    }

    @Test
    public void findSimpleNumbersValidTest() {
        try {
            int[] arr = {3, 5, 17, 4, 16};
            CustomArray customArray = new CustomArray(arr);
            int[] expectedSimpleNumbers = service.findSimpleNumbers(customArray);
            int[] actualSimpleNumbers = {3, 5, 17};
            boolean flag = true;
            for (int i = 0; i < expectedSimpleNumbers.length; i++) {
                if (expectedSimpleNumbers[i] != actualSimpleNumbers[i]) {
                    flag = false;
                    break;
                }
            }
            assertTrue(flag);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void findSimpleNumbersExceptionTest() throws ProgramException {
        service.findSimpleNumbers(null);
    }

    @Test
    public void findFibonacciNumbersValidTest() {
        try {
            int[] arr = {1, 2, 3, 5, 8, 11, 14, 15};
            CustomArray customArray = new CustomArray(arr);
            int[] expectedSimpleNumbers = service.findFibonacciNumbers(customArray);
            int[] actualSimpleNumbers = {1, 2, 3, 5, 8};
            boolean flag = true;
            for (int i = 0; i < actualSimpleNumbers.length; i++) {
                if (expectedSimpleNumbers[i] != actualSimpleNumbers[i]) {
                    flag = false;
                    break;
                }
            }
            assertTrue(flag);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void findFibonacciNumbersExceptionTest() throws ProgramException {
        service.findFibonacciNumbers(null);
    }

    @Test
    public void findDifferentDigitsValidTest() {
        try {
            int[] arr = {123, 234, 356, 551, 855, 111, 144, 115};
            CustomArray customArray = new CustomArray(arr);
            int[] expectedSimpleNumbers = service.findDifferentDigitsNumbers(customArray);
            int[] actualSimpleNumbers = {123, 234, 356};
            boolean flag = true;
            for (int i = 0; i < actualSimpleNumbers.length; i++) {
                if (expectedSimpleNumbers[i] != actualSimpleNumbers[i]) {
                    flag = false;
                    break;
                }
            }
            assertTrue(flag);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void findDifferentDigitsNumbersExceptionTest() throws ProgramException {
        service.findDifferentDigitsNumbers(null);
    }

    @Test
    public void findNumberValidTest() {
        try {
            int[] arr = {123, 234, 356, 551, 855, 111, 144, 115};
            CustomArray customArray = new CustomArray(arr);
            int key = 234;
            int expectedIndex = service.findNumber(customArray, key);
            int actualIndex = 1;
            assertEquals(expectedIndex, actualIndex);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test
    public void findNumberInvalidTest() {
        try {
            int[] arr = {123, 234, 356, 551, 855, 111, 144, 115};
            CustomArray customArray = new CustomArray(arr);
            int key = 234;
            int expectedIndex = service.findNumber(customArray, key);
            int actualIndex = 1;
            assertEquals(expectedIndex, actualIndex);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void findNumberExceptionTest() throws ProgramException {
        service.findNumber(null, 1);
    }
}