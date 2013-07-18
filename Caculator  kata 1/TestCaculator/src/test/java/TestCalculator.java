import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/15/13
 * Time: 10:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
    @Test
    public void testAddZeroNumber() throws Exception {
        assertTrue(Calculator.add("") == 0);
        //assertFalse(Calculator.add("") == 2);
    }

    @Test
    public void testAddOneNumber() throws Exception {
        assertTrue(Calculator.add("1") == 1);
        //assertFalse(Calculator.add("1") == 2);
    }

    @Test
    public void testAddTwoNumber() throws Exception {
        assertTrue(Calculator.add("1,2") == 3);
        //assertFalse(Calculator.add("1,2") == 4);
    }

    @Test
    public void testAddUnknowAmountNumber() throws Exception {
        assertTrue(Calculator.add("1,2,3,4") == 10);
    }

    @Test
    public void testAddHandleNewLines() throws Exception {
        assertTrue(Calculator.add("1\n2,3,4") == 10);
    }

    @Test
    public void testSupportDifferenceDelimeters() throws Exception {
        assertTrue(Calculator.add("//;\n5;6") == 11);
    }

    @Test
    public void testRaiseException() {
        try {
            Calculator.add("//;\n5;-1");
            fail("Exception expected");
        } catch (Exception e) {
        }
    }

    @Test
    public void testRaiseMessage() {
        try {
            Calculator.add("//;\n5;-1");
        } catch (Exception e) {
            assertEquals("negatives not allowed: -1", e.getMessage());
        }
    }

    @Test
    public void testRaiseMessageWithMultipleNegative() {
        try {
            Calculator.add("//;\n5;-1;-2");
        } catch (Exception e) {
            assertEquals("negatives not allowed: -1 -2", e.getMessage());
        }
    }

    @Test
    public void testIgnoreMoreThan10000() throws Exception {
        assertTrue(Calculator.add("//;\n5;1001") == 5);
    }

    @Test
    public void testDelimiterAnyLength() throws Exception {
        assertTrue(Calculator.add("//[***]\n1***2***3") == 6);
    }

    @Test
    public void testMultipleDelimiter() throws Exception {
        assertTrue(Calculator.add("//[*][%]\n1*2%3") == 6);
    }

    @Test
    public void testMultipleDelimiterAnyLength() throws Exception {
        assertTrue(Calculator.add("//[**6*][%6%]\n1**6*2%6%3") == 6);
    }
}
