package com.anton.day4_1.creator;

import com.anton.day4_1.entity.CustomArray;
import com.anton.day4_1.exception.ProgramException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class ArrayCreatorTest {
    ArrayCreator creator;

    @BeforeClass
    public void setup() {
        creator = new ArrayCreator();
    }

    @Test
    public void createRandomArrayValidTest() {
        try {
            int size = 10;
            CustomArray temp = creator.createRandomArray(size);
            assertEquals(temp.getSize(), size);
        } catch (ProgramException e) {
            fail();
        }
    }

    @Test(expectedExceptions = ProgramException.class)
    public void createRandomArrayExceptionTest() throws ProgramException {
        int size = -1;
        creator.createRandomArray(size);
    }

    @Test
    public void createCustomArrayValidTest() {
        try {
            String numbers = "1 2 3 4 5";
            CustomArray expectedArr = creator.createCustomArray(numbers);
            int[] temp = {1, 2, 3, 4, 5};
            CustomArray actualArr = new CustomArray(temp);
            assertEquals(expectedArr, actualArr);
        } catch (ProgramException e) {
            fail();
        }
    }

    @DataProvider(name = "invalidArr")
    public static Object[][] createInvalidCustomArray() {
        return new Object[][]{
                {null}, {"1 2 3 f"}, {""}
        };
    }

    @Test(expectedExceptions = ProgramException.class, dataProvider = "invalidArr")
    public void createCustomArrayExceptionTest(String numbers) throws ProgramException {
        creator.createCustomArray(numbers);
    }

    @Test
    public void createFileArrayValidTest() {
        try {
            String fileName = "data/defaultFile.txt";
            CustomArray expectedArr = creator.createFileArray(fileName);
            int[] temp = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
            CustomArray actualArr = new CustomArray(temp);
            assertEquals(expectedArr, actualArr);
        } catch (ProgramException e) {
            fail();
        }
    }

    @DataProvider(name = "invalidFilePath")
    public Object[][] createFilePath() {
        return new Object[][]{
                {"data/nonExistingFile1234.txt"},
                {null},
                {"data/invalidData.txt"}
        };
    }

    @Test(dataProvider = "invalidFilePath", expectedExceptions = ProgramException.class)
    public void createFileArrayExceptionTest(String fileName) throws ProgramException {
        creator.createFileArray(fileName);
    }
}
