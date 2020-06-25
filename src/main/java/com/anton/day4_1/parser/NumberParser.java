package com.anton.day4_1.parser;

import com.anton.day4_1.exception.ProgramException;
import com.anton.day4_1.validator.NumberValidator;

public class NumberParser {
    private NumberValidator validator = new NumberValidator();

    public int[] parseIntArr(String numbers) throws ProgramException {
        if (numbers == null) {
            throw new ProgramException();
        }
        if (!validator.validateStringToIntArr(numbers)) {
            throw new ProgramException();
        }
        String[] strArr = numbers.split(" ");
        int length = strArr.length;
        int[] intArr = new int[length];
        for (int i = 0; i < length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    public int parsePositiveNumber(String number) throws ProgramException {
        if (number == null) {
            throw new ProgramException();
        }
        if (!validator.validatePositiveNumber(number)) {
            throw new ProgramException();
        }
        return Integer.parseInt(number);
    }
}
