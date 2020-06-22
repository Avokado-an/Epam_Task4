package com.anton.day4.task1.entity;

import java.util.Random;

public class CustomArray {
    private static final int DEFAULT_SIZE = 10;

    private int[] arr;
    private int size = DEFAULT_SIZE;

    public CustomArray() {
        fillWithRandom();
    }

    public CustomArray(int size) {
        fillWithRandom();
        this.size = size;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private void fillWithRandom() {
        arr = new int[size];
        Random random = new Random();
        int range = 10;
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(range);
        }
    }
}
