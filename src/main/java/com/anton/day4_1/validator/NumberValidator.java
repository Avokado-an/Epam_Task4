package com.anton.day4_1.validator;

public class NumberValidator {
    public boolean validateStringToIntArr(String numbers) {
        boolean flag = false;
        if (numbers != null) {
            flag = true;
            try {
                String[] strArr = numbers.split(" ");
                for (String s : strArr) {
                    Integer.parseInt(s);
                }
            } catch (NumberFormatException ex) {
                flag = false;
            }
        }
        return flag;
    }

    public boolean validateNumber(String number) {
        boolean flag = true;
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException ex) {
            flag = false;
        }
        return flag;
    }

    public boolean validatePositiveNumber(String number) {
        boolean flag = true;
        try {
            int res = Integer.parseInt(number);
            if (res < 0) {
                flag = false;
            }
        } catch (NumberFormatException ex) {
            flag = false;
        }
        return flag;
    }
}
