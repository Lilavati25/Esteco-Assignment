/**
 * This class contains unit tests for the AddCalculator class, which provides functionality to perform addition operations
 * on a set of numbers with various input scenarios.
 *
 * @author Lilavati Shivaji Mhaske
 */
package com.esteco.assignment;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplyCalculatorTest {

    /**
     * Test case to verify the behavior of the add() method when handling an unknown number of arguments.
     */
    @Test
    public void testAddMethod_UnknownNumberOfArguments() {
        String numbersSet1 = "1.5,2,3";
        String numbersSet2 = "5,10,20";
        String numbersSet3 = "10,20,30";

        String result = MultiplyCalculator.multiply(numbersSet1, numbersSet2, numbersSet3);

        assertEquals( "9\n1000\n6000", result);
    }

    /*
     * This test verifies the behavior of the add() method for valid input when handling the newline character as a delimiter.
     */
    @Test
    public void testNewlineSeparator_ValidInput() {
        assertEquals("30", MultiplyCalculator.multiply("2\n3,5"));
    }

    /**
     * Test case to verify the behavior of the add() method when the input string ends with a separator
     * and does not contain a number in the last position.
     */
    @Test
    public void testAddMethod_InvalidInput_MissingNumberInLastPosition() {
        String numbers = "1,3,";
        String expectedErrorMessage = "Number expected but EOF found";

        String actualResult = MultiplyCalculator.multiply(numbers);

        assertEquals(expectedErrorMessage, actualResult);
    }

    /**
     * Test case to verify the behavior of the add() method when handling custom separators.
     */
    @Test
    public void testAddMethod_CustomSeparators() {
        String numbers1 = "//;\n1;2";
        String numbers2 = "//|\n1|2.5|3";
        String numbers3 = "//sep\n2sep3";

        String result1 = MultiplyCalculator.multiply(numbers1);
        String result2 = MultiplyCalculator.multiply(numbers2);
        String result3 = MultiplyCalculator.multiply(numbers3);

        assertEquals("2", result1);
        assertEquals("7.5", result2);
        assertEquals("6", result3);
    }

    /**
     * Test case to verify the behavior of the add() method when handling negative numbers.
     */
    @Test
    public void testAddMethod_NegativeNumbers() {

        String numbers1 = "-1,2";
        String numbers2 = "2,-4,-5";
        String expectedErrorMessage = "Negative numbers not allowed : -4\nNegative numbers not allowed : -5";

        String result1 = MultiplyCalculator.multiply(numbers1);
        String result2 = MultiplyCalculator.multiply(numbers2);

        assertEquals("Negative numbers not allowed : -1", result1);
        assertEquals(expectedErrorMessage, result2);
    }

    /**
     * Test case to verify the behavior of the add() method when encountering multiple errors.
     */
    @Test
    public void testAddMethod_MultipleErrors() {
        String numbers = "-1,,-2";
        String expectedErrorMessage = "Negative numbers not allowed : -1\nNumber expected but ',' found at position 1\nNegative numbers not allowed : -2";

        String result = MultiplyCalculator.multiply(numbers);

        assertEquals(expectedErrorMessage, result);
    }
}
