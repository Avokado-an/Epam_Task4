package com.anton.day4_1.parser;

import com.anton.day4_1.exception.ProgramException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class NumberParserTest {
    NumberParser parser;

    @BeforeClass
    public void setup() {
        parser = new NumberParser();
    }

    @Test
    public void parseIntArrValidTest() {
        try {
            int[] actual = {1, 2, 3};
            int[] expected = parser.parseIntArr("1 2 3");
            assertEquals(actual, expected);
        } catch (ProgramException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidNumbers")
    public static Object[][] createInvalidNumbers() {
        return new Object[][]{
                {"1 2 3 4   5 "}, {"1 2 3 a"}, {""}, {"111111111111111111111"}, {null}
        };
    }

    @Test(dataProvider = "invalidNumbers", expectedExceptions = ProgramException.class)
    public void parseIntArrExceptionTest(String numbers) throws ProgramException {
        parser.parseIntArr(numbers);
    }

    @Test
    public void parsePositiveNumberValidTest() {
        try {
            int expected = parser.parsePositiveNumber("1");
            int actual = 1;
            assertEquals(actual, expected);
        } catch (ProgramException ex) {
            fail();
        }
    }

    @DataProvider(name = "invalidNegativeNumbers")
    public static Object[][] createInvalidNumber() {
        return new Object[][]{
                {"-1"}, {"-1."}, {"-1a"}, {"a"}, {"-a"}, {"1."}, {"1a"}, {null}
        };
    }

    @Test(dataProvider = "invalidNegativeNumbers", expectedExceptions = ProgramException.class)
    public void parsePositiveNumberExceptionTest(String number) throws ProgramException {
        parser.parsePositiveNumber(number);
    }
}
