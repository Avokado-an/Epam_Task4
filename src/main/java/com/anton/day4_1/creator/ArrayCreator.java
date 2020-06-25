package com.anton.day4_1.creator;

import com.anton.day4_1.consoleReader.ConsoleReader;
import com.anton.day4_1.entity.CustomArray;
import com.anton.day4_1.exception.ProgramException;
import com.anton.day4_1.parser.NumberParser;
import com.anton.day4_1.service.FileReaderService;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class ArrayCreator {
    public CustomArray createRandomArray(int size) throws ProgramException {
        if (size < 1) {
            throw new ProgramException();
        }
        int[] arr;
        try {
            Random random = SecureRandom.getInstanceStrong();
            arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = random.nextInt(999);
            }
        } catch (NoSuchAlgorithmException ex) {
            throw new ProgramException();
        }
        return new CustomArray(arr);
    }

    public CustomArray createCustomArray(String arr) throws ProgramException {
        NumberParser parser = new NumberParser();
        int[] tempArr = parser.parseIntArr(arr);
        return new CustomArray(tempArr);
    }

    public CustomArray createConsoleArray() throws ProgramException {
        ConsoleReader in = new ConsoleReader();
        String numbers = in.inputString();
        return createCustomArray(numbers);
    }

    public CustomArray createFileArray(String fileName) throws ProgramException {
        FileReaderService in = new FileReaderService();
        String numbers = in.readData(fileName);
        return createCustomArray(numbers);
    }
}
