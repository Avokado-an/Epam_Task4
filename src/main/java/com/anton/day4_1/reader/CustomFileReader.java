package com.anton.day4_1.reader;

import com.anton.day4_1.exception.ProgramException;

import java.io.FileInputStream;
import java.io.IOException;

public class CustomFileReader {
    public String readData(String path) throws ProgramException {
        if (path == null) {
            throw new ProgramException();
        }
        StringBuilder resultingArr;
        try (FileInputStream fin = new FileInputStream(path)) {
            int i;
            resultingArr = new StringBuilder();
            while ((i = fin.read()) != -1) {
                resultingArr.append((char) i);
            }
        } catch (IOException ex) {
            throw new ProgramException();
        }
        return resultingArr.toString();
    }
}
