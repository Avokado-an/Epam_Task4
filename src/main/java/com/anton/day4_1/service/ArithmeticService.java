package com.anton.day4_1.service;

public class ArithmeticService {
    public boolean isSimpleNumber(int number) {
        boolean flag = true;
        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isFibonacciNumber(int number) {
        return isPerfectSquare(5 * number * number + 4) ||
                isPerfectSquare(5 * number * number - 4);
    }

    public boolean hasThreeDifferentDigits(int number) {
        boolean flag = false;
        if (isThreeDigitNumber(number)) {
            int firstDigit = number % 10;
            int secondDigit = (number / 10) % 10;
            int thirdDigit = (number / 100) % 10;
            flag = firstDigit != secondDigit &&
                    firstDigit != thirdDigit &&
                    secondDigit != thirdDigit;
        }
        return flag;
    }

    private boolean isPerfectSquare(int x) {
        int s = (int) Math.sqrt(x);
        return (s * s == x);
    }

    private boolean isThreeDigitNumber(int number) {
        int digits = number / 100;
        return digits > 0 && digits < 10;
    }
}
