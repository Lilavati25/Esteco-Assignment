/**
 * This class contains unit tests for the AddCalculator class, which provides functionality to perform addition operations
 * on a set of numbers with various input scenarios.
 *
 * @author Lilavati Shivaji Mhaske
 */
package com.esteco.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCalculatorTest {

    /**
     * Test case to verify the behavior of the add() method when handling an unknown number of arguments.
     */
    @Test
    public void testAddMethod_UnknownNumberOfArguments() {
        String numbersSet1 = "1,2,3,4,5";
        String numbersSet2 = "5,10,15,20,25";
        String numbersSet3 = "10,20,30,40,50";

        String result = AddCalculator.add(numbersSet1, numbersSet2, numbersSet3);

        assertEquals("15\n75\n150", result);
    }

    /*
     * This test verifies the behavior of the add() method for valid input when handling the newline character as a delimiter.
     */
    @Test
    public void testNewlineSeparator_ValidInput() {
        assertEquals("10", AddCalculator.add("2\n3,5"));
    }

    /*
     * This test verifies the behavior of the add() method for invalid input when handling the newline character as a delimiter.
     */
    @Test
    public void testNewlineSeparator_InValidInput() {
        assertEquals("Number expected but '\n' found at position 6", AddCalculator.add("175.2,\n35"));
    }

    /**
     * Test case to verify the behavior of the add() method when the input string ends with a separator
     * and does not contain a number in the last position.
     */
    @Test
    public void testAddMethod_InvalidInput_MissingNumberInLastPosition() {
        String numbers = "1,3,";
        String expectedErrorMessage = "Number expected but EOF found";

        String actualResult = AddCalculator.add(numbers);

        assertEquals("The add() method should return the correct error message for missing number in the last position.",
                expectedErrorMessage, actualResult);
    }

    /**
     * Test case to verify the behavior of the add() method when handling custom separators.
     */
    @Test
    public void testAddMethod_CustomSeparators() {
        String numbers1 = "//;\n1;2";
        String numbers2 = "//|\n1|2|3";
        String numbers3 = "//sep\n2sep3";
        String numbers4 = "//|\n1|2,3";
        String expectedErrorMessage = "'|' expected but ',' found at position 3.";

        String result1 = AddCalculator.add(numbers1);
        String result2 = AddCalculator.add(numbers2);
        String result3 = AddCalculator.add(numbers3);
        String result4 = AddCalculator.add(numbers4);

        assertEquals("3", result1);
        assertEquals("6", result2);
        assertEquals("5", result3);
        assertEquals(expectedErrorMessage, result4);
    }

    /**
     * Test case to verify the behavior of the add() method when handling negative numbers.
     */
    @Test
    public void testAddMethod_NegativeNumbers() {

        String numbers1 = "-1,2";
        String numbers2 = "2,-4,-5";
        String expectedErrorMessage = "Negative not allowed : -4, -5";

        String result1 = AddCalculator.add(numbers1);
        String result2 = AddCalculator.add(numbers2);

        assertEquals("Negative not allowed : -1", result1);
        assertEquals(expectedErrorMessage, result2);
    }

    /**
     * Test case to verify the behavior of the add() method when encountering multiple errors.
     */
    @Test
    public void testAddMethod_MultipleErrors() {
        String numbers = "-1,,-2";
        String expectedErrorMessage = "Negative not allowed : -1\nNumber expected but ',' found at position 3\nNegative not allowed : -2";

        String result = AddCalculator.add(numbers);

        assertEquals(expectedErrorMessage, result);
    }
}
