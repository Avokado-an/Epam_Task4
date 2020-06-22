package com.anton.day4.task1.service;

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
        double goldenRatio = (1 + Math.sqrt(5)) / 2;
        double lowerIntervalGap = goldenRatio * number - 1. / number;
        double higherIntervalGap = goldenRatio * number + 1. / number;
        return (int) lowerIntervalGap - (int) higherIntervalGap == 1;
    }

    public boolean hasThreeDifferentDigits(int number) {
        boolean flag = false;
        if(isThreeDigitNumber(number)) {
            int firstDigit = number % 10;
            int secondDigit = (number / 10) % 10;
            int thirdDigit = (number / 100) % 10;
            flag = firstDigit != secondDigit &&
                    firstDigit != thirdDigit &&
                    secondDigit != thirdDigit;
        }
        return flag;
    }

    private boolean isThreeDigitNumber(int number) {
        int digits = number / 1000;
        return digits > 0 && digits < 10;
    }
}
