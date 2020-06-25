package com.anton.day4_2.comparator;

import java.util.Comparator;

public class SumOfValuesComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2) {
        return calculateSum(arr1) - calculateSum(arr2);
    }

    private int calculateSum(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }
}
