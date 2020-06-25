package com.anton.day4_2.service;

import java.util.Comparator;

public class SortingService {
    public void bubbleSort(int[][] array, Comparator<int[]> comparator, boolean isMinToMaxOrder) {
        if (array != null && comparator != null) {
            int length = array.length;
            for (int i = 0; i < length; i++) {
                for (int j = length - 1; j > i; j--) {
                    if (compare(array[i], array[j], comparator, isMinToMaxOrder) > 0) {
                        int[] temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    public boolean isSorted(int[][] arr, Comparator<int[]> comparator, boolean isMinToMaxOrder) {
        boolean flag = false;
        if (arr != null && comparator != null) {
            flag = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (compare(arr[i], arr[i + 1], comparator, isMinToMaxOrder) > 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }

    private int compare(int[] arr1, int[] arr2, Comparator<int[]> comparator, boolean isMinToMaxOrder) {
        int res = comparator.compare(arr1, arr2);
        if (!isMinToMaxOrder) {
            res *= -1;
        }
        return res;
    }
}
