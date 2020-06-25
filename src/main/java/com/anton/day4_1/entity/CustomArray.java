package com.anton.day4_1.entity;

public class CustomArray {
    private static final int DEFAULT_SIZE = 10;

    private int[] arr;

    public CustomArray() {
        arr = new int[DEFAULT_SIZE];
    }

    public CustomArray(int size) {
        if (size <= 0) {
            arr = new int[DEFAULT_SIZE];
        } else {
            arr = new int[size];
        }
    }

    public CustomArray(int[] arr) {
        if (arr == null) {
            arr = new int[DEFAULT_SIZE];
        } else {
            this.arr = arr;
        }
    }

    public int[] getArr() {
        int[] cloneArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cloneArr[i] = arr[i];
        }
        return cloneArr;
    }

    public boolean setArr(int[] arr) {
        boolean flag = false;
        if (arr != null) {
            this.arr = arr;
            flag = true;
        }
        return flag;
    }

    public boolean setElement(int index, int element) {
        boolean flag = false;
        if (index > -1 && index < arr.length) {
            arr[index] = element;
            flag = true;
        }
        return flag;
    }

    public int getSize() {
        return arr.length;
    }

    public int getElement(int index) {
        return arr[index];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        if (getSize() != that.getSize())
            return false;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != that.getElement(i)) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public int hashCode() {
        int result = 17;
        for (int element : arr) {
            result = 31 * result + element;
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("CustomArray(size = %d):%n\t%s", getSize(), arrayToString());
    }

    private String arrayToString() {
        StringBuilder res = new StringBuilder();
        for (int i : arr) {
            res.append(i).append(" ");
        }
        return res.toString();
    }
}
