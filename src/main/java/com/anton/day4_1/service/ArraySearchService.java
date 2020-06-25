package com.anton.day4_1.service;

import com.anton.day4_1.entity.CustomArray;
import com.anton.day4_1.exception.ProgramException;

public class ArraySearchService { //change to customArray class
    public int findMinValue(CustomArray customArray) throws ProgramException {
        if (customArray == null) {
            throw new ProgramException();
        }
        int min = customArray.getElement(0);
        for (int i = 1; i < customArray.getSize(); i++) {
            int current = customArray.getElement(i);
            if (min > current) {
                min = current;
            }
        }
        return min;
    }

    public int findMaxValue(CustomArray customArray) throws ProgramException {
        if (customArray == null) {
            throw new ProgramException();
        }
        int max = customArray.getElement(0);
        for (int i = 1; i < customArray.getSize(); i++) {
            int current = customArray.getElement(i);
            if (max < current) {
                max = current;
            }
        }
        return max;
    }

    public int[] findSimpleNumbers(CustomArray customArray) throws ProgramException {
        if (customArray == null) {
            throw new ProgramException();
        }
        ArithmeticService service = new ArithmeticService();
        int[] res = new int[customArray.getSize()];
        int i = 0;
        for (int elem : customArray.getArr()) {
            if (service.isSimpleNumber(elem)) {
                res[i] = elem;
                i++;
            }
        }
        return res;
    }

    public int[] findFibonacciNumbers(CustomArray customArray) throws ProgramException {
        if (customArray == null) {
            throw new ProgramException();
        }
        ArithmeticService service = new ArithmeticService();
        int[] res = new int[customArray.getSize()];
        int i = 0;
        for (int elem : customArray.getArr()) {
            if (service.isFibonacciNumber(elem)) {
                res[i] = elem;
                i++;
            }
        }
        return res;
    }

    public int[] findDifferentDigitsNumbers(CustomArray customArray) throws ProgramException {
        if (customArray == null) {
            throw new ProgramException();
        }
        ArithmeticService service = new ArithmeticService();
        int[] res = new int[customArray.getSize()];
        int i = 0;
        for (int elem : customArray.getArr()) {
            if (service.hasThreeDifferentDigits(elem)) {
                res[i] = elem;
                i++;
            }
        }
        return res;
    }

    public int findNumber(CustomArray customArray, int key) throws ProgramException {
        if (customArray == null) {
            throw new ProgramException();
        }
        ArraySortService service = new ArraySortService(); // change in order to not send whole arr
        int[] tempArr = customArray.getArr().clone();
        service.selectionSort(new CustomArray(tempArr));
        int first = 0;
        int last = customArray.getSize();
        int index = -1;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (customArray.getElement(mid) < key) {
                first = mid + 1;
            } else if (customArray.getElement(mid) > key) {
                last = mid - 1;
            } else if (customArray.getElement(mid) == key) {
                index = mid;
                break;
            }
        }
        return index;
    }
}
