package src.test.java.com.maazrk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import src.main.java.com.maazrk.StringCalculator;

public class StringCalculatorTest {
    StringCalculator stringCalculator;


    @Before
    public void init() {
        stringCalculator = new StringCalculator();
    }

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

    @Test
    public void shouldThrowExceptionIfANegativeNumberIsGiven() {

        try {
            stringCalculator.Add("//;\n-1;2");
            fail("Exception should be thrown");
        }
        catch(RuntimeException ex) {
            assertEquals("negatives not allowed: [-1]", ex.getMessage());
        }
    }

    @Test
    public void shouldThrowExceptionIfMultipleNegativeNumbersAreGiven() {

        try {
            stringCalculator.Add("//;\n-1;-2");
            fail("Exception should be thrown");
        }
        catch(RuntimeException ex) {
            assertEquals("negatives not allowed: [-1, -2]", ex.getMessage());
        }
    }

    @Test
    public void shouldReturnTheNumberOfTimesAddWasCalled() {
        stringCalculator.Add("");
        stringCalculator.Add("1,2");
        stringCalculator.Add("1\n3");
        assertEquals(3, stringCalculator.GetCalledCount());
    }

    @Test
    public void shouldIgnoreNumbersGreaterThan1000() {
        assertEquals(1, stringCalculator.Add("1001,1"));
    }

    @Test
    public void shouldSupportDelimiterOfLengthThree() {
        assertEquals(6, stringCalculator.Add("//[***]\n1***2***3"));
    }

    @Test
    public void shouldSupportDelimiterOfLengthFive() {
        assertEquals(10, stringCalculator.Add("//[%%%%%]\n1%%%%%2%%%%%7"));
    }
}