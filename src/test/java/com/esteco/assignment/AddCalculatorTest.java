package com.esteco.assignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddCalculatorTest {

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

        // Perform the tests
        String result1 = AddCalculator.add(numbers1);
        String result2 = AddCalculator.add(numbers2);
        String result3 = AddCalculator.add(numbers3);
        String result4 = AddCalculator.add(numbers4);

        // Verify the results
        assertEquals("3", result1);
        assertEquals("6", result2);
        assertEquals("5", result3);
        assertEquals(expectedErrorMessage, result4);
    }


}
