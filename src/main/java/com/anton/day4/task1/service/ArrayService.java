package com.anton.day4.task1.service;

public class ArrayService {
    public int findMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    public int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public int[] findSimpleNumbers(int[] arr) {
        ArithmeticService service = new ArithmeticService();
        int[] res = new int[arr.length];
        int i = 0;
        for (int elem : arr) {
            if (service.isSimpleNumber(elem)) {
                res[i] = elem;
                i++;
            }
        }
        return res;
    }

    public int[] findFibonacciNumbers(int[] arr) {
        ArithmeticService service = new ArithmeticService();
        int[] res = new int[arr.length];
        int i = 0;
        for (int elem : arr) {
            if (service.isFibonacciNumber(elem)) {
                res[i] = elem;
                i++;
            }
        }
        return res;
    }

    public int[] findDifferentDigitsNumbers(int[] arr) { // TODO: 22.06.2020 rename it.
        ArithmeticService service = new ArithmeticService();
        int[] res = new int[arr.length];
        int i = 0;
        for (int elem : arr) {
            if (service.hasThreeDifferentDigits(elem)) {
                res[i] = elem;
                i++;
            }
        }
        return res;
    }

    public int findNumber(int[] arr, int key) {
        int[] tempArr = arr.clone();
        selectionSort(tempArr);
        int first = 0;
        int last = arr.length;
        int index = -1;

        while (first <= last) {
            int mid = (first + last) / 2;
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] > key) {
                last = mid - 1;
            } else if (arr[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    /*public void shellSort(int[] arr) { // TODO: 22.06.2020 check more obvious one and learn other sorts
        int increment = arr.length / 2;
        while (increment > 0) {
            for (int i = increment; i < arr.length; i++) {
                int j = i;
                int temp = arr[i];
                while (j >= increment && arr[j - increment] > temp) {
                    arr[j] = arr[j - increment];
                    j = j - increment;
                }
                arr[j] = temp;
            }
            if (increment == 2) {
                increment = 1;
            } else {
                increment *= (5.0 / 11);
            }
        }
    }*/

    public void selectionSort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public void bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
