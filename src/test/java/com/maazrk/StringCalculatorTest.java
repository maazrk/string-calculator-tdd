package src.test.java.com.maazrk;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import src.main.java.com.maazrk.StringCalculator;

public class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void emptyStringShouldReturnZero() {
        assertEquals(0, stringCalculator.Add(""));
    }

    @Test
    public void singleNumberShouldbereturnedAsItIs() {
        assertEquals(42, stringCalculator.Add("42"));
    }

    @Test
    public void shouldReturnSumOfTwoNumbers() {
        assertEquals(7, stringCalculator.Add("4,3"));
    }

}