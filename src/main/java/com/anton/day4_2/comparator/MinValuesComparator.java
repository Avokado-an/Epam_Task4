package com.anton.day4_2.comparator;

import java.util.Comparator;

public class MinValuesComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2) {
        return findMin(arr2) - findMin(arr1);
    }

    private int findMin(int[] arr) {
        int min = arr[0];
        for (int element : arr) {
            if (min > element) {
                min = element;
            }
        }
        return min;
    }
}
