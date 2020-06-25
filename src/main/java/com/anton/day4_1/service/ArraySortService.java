package com.anton.day4_1.service;

import com.anton.day4_1.entity.CustomArray;
import com.anton.day4_1.exception.ProgramException;

public class ArraySortService {
    public void shellSort(CustomArray arr) throws ProgramException { //another sorting algorithm
        if (arr == null) {
            throw new ProgramException();
        }
        int size = arr.getSize();
        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i++) {
                int temp = arr.getElement(i);
                int j;
                for (j = i; j >= gap && arr.getElement(j - gap) > temp; j -= gap) {
                    arr.setElement(j, arr.getElement(j - gap));
                }
                arr.setElement(j, temp);
            }
        }
    }

    public void selectionSort(CustomArray arr) throws ProgramException {
        if (arr == null) {
            throw new ProgramException();
        }
        int size = arr.getSize();
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr.getElement(j) < arr.getElement(minIndex)) {
                    minIndex = j;
                }
            }
            int temp = arr.getElement(minIndex);
            arr.setElement(minIndex, arr.getElement(i));
            arr.setElement(i, temp);
        }
    }

    public void bubbleSort(CustomArray arr) throws ProgramException {
        if (arr == null) {
            throw new ProgramException();
        }
        int length = arr.getSize();
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr.getElement(j) > arr.getElement(j + 1)) {
                    int temp = arr.getElement(j);
                    arr.setElement(j, arr.getElement(j + 1));
                    arr.setElement(j + 1, temp);
                }
            }
        }
    }
}
