package com.anton.day4_1.service;

import com.anton.day4_1.entity.CustomArray;
import com.anton.day4_1.exception.ProgramException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArraySortServiceTest {
    ArraySortService service;

    @BeforeClass
    public void setup() {
        service = new ArraySortService();
    }

    @Test
    public void shellSortValidTest() {
        try {
            int[] tempArr = {1, 3, 2, 17, 11, -1234};
            CustomArray expectedArr = new CustomArray(tempArr);
            service.shellSort(expectedArr);
            int[] actualTempArr = {-1234, 1, 2, 3, 11, 17};
            CustomArray actualArr = new CustomArray(actualTempArr);
            assertEquals(expectedArr, actualArr);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void shellSortExceptionTest() throws ProgramException {
        service.shellSort(null);
    }

    @Test
    public void selectionSortValidTest() {
        try {
            int[] tempArr = {1, 3, 2, 17, 11, -1234};
            CustomArray expectedArr = new CustomArray(tempArr);
            service.selectionSort(expectedArr);
            int[] actualTempArr = {-1234, 1, 2, 3, 11, 17};
            CustomArray actualArr = new CustomArray(actualTempArr);
            assertEquals(expectedArr, actualArr);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void selectionSortExceptionTest() throws ProgramException {
        service.selectionSort(null);
    }

    @Test
    public void bubbleSortValidTest() {
        try {
            int[] tempArr = {1, 3, 2, 17, 11, -1234};
            CustomArray expectedArr = new CustomArray(tempArr);
            service.bubbleSort(expectedArr);
            int[] actualTempArr = {-1234, 1, 2, 3, 11, 17};
            CustomArray actualArr = new CustomArray(actualTempArr);
            assertEquals(expectedArr, actualArr);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void bubbleSortExceptionTest() throws ProgramException {
        service.bubbleSort(null);
    }
}
