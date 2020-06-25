package com.anton.day4_2.comparator;

import java.util.Comparator;

public class MaxValuesComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2) {
        return findMax(arr1) - findMax(arr2);
    }

    private int findMax(int[] arr) {
        int max = arr[0];
        for (int element : arr) {
            if (max < element) {
                max = element;
            }
        }
        return max;
    }
}
