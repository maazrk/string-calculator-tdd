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

    @Test
    public void shouldReturnSumOfMoreThanTwoNumbers() {
        assertEquals(14, stringCalculator.Add("7,3,4"));
    }

    @Test
    public void shouldAcceptNewLineAsADelimiter() {
        assertEquals(14, stringCalculator.Add("7\n3,4"));
    }

    @Test
    public void shouldAcceptCustomDelimiter() {
        assertEquals(3, stringCalculator.Add("//;\n1;2"));
    }
}