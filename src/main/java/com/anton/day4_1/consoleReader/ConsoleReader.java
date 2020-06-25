package com.anton.day4_1.consoleReader;

import java.util.Scanner;

public class ConsoleReader {
    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
