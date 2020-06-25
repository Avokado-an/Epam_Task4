package com.anton.day4_2.service;

import com.anton.day4_2.comparator.MaxValuesComparator;
import com.anton.day4_2.comparator.MinValuesComparator;
import com.anton.day4_2.comparator.SumOfValuesComparator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Comparator;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class SortingServiceTest {
    private SortingService service;

    @BeforeClass
    public void setup() {
        service = new SortingService();
    }

    @DataProvider(name = "comparators")
    public Object[][] createComparators() {
        return new Object[][]{
                {new SumOfValuesComparator(), true},
                {new MaxValuesComparator(), true},
                {new MinValuesComparator(), true},
                {new SumOfValuesComparator(), false},
                {new MaxValuesComparator(), false},
                {new MinValuesComparator(), false}
        };
    }

    @Test(dataProvider = "comparators")
    public void bubbleSortValidTest(Comparator<int[]> comparator, boolean sortingOrder) {
        int[][] arr = {
                {1, 2, 3},
                {5},
                {1, 4, 6},
                {-1, 10}
        };
        service.bubbleSort(arr, comparator, sortingOrder);
        for (int[] line : arr) {
            for (int element : line) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        boolean flag = service.isSorted(arr, comparator, sortingOrder);
        assertTrue(flag);
    }

    @DataProvider(name = "invalidComparators")
    public Object[][] createInvalidComparators() {
        return new Object[][]{
                {new int[][]{{1, 2, 3}, {5}, {1, 4, 6}, {-1, 10}}, null, true},
                {null, new MaxValuesComparator(), false},
                {null, null, false}
        };
    }

    @Test(dataProvider = "invalidComparators")
    public void bubbleSortInvalidTest(int[][] arr, Comparator<int[]> comparator, boolean sortingOrder) {
        service.bubbleSort(arr, comparator, sortingOrder);
        boolean flag = service.isSorted(arr, comparator, sortingOrder);
        assertFalse(flag);
    }
}
