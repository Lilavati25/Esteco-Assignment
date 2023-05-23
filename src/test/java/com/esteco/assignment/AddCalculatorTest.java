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
}
