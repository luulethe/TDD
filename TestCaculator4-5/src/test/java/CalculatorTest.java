import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/4/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class CalculatorTest {
    @Test
    public void testEmptyString() throws Exception {
        assertEquals(Calculator.add(""), 0);
    }

    @Test
    public void testOneNumber() throws Exception {
        assertEquals(Calculator.add("1"), 1);
    }

    @Test
    public void testTwoNumber() throws Exception {
        assertEquals(Calculator.add("1,2"), 3);
    }

    @Test
    public void testUnknowNumber() throws Exception {
        assertEquals(Calculator.add("1,2,3"), 6);
    }

    @Test
    public void testHavingNewLine() throws Exception {
        assertEquals(Calculator.add("1\n2,3"), 6);
    }

    @Test
    public void testHavingDifferenceDelimiter() throws Exception {
        assertEquals(Calculator.add("//;\n1;2"), 3);
    }

    @Test
    public void testRaiseException() throws Exception {
        try {
            Calculator.add("//;\n1;-2");
            fail("Exception expected");
        } catch (Exception e) {

        }
    }

    @Test
    public void testMessageException() throws Exception {
        try {
            Calculator.add("//;\n1;-2");
            fail("Exception expected");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -2");

        }
    }

    @Test
    public void testIgnoreMoreThan1000() throws Exception {
        assertEquals(Calculator.add("//;\n1;1001;2"), 3);
    }

    @Test
    public void testDelimiterAnyLength() throws Exception {
        assertEquals(Calculator.add("//[***]\n1***2***3"), 6);
    }

    @Test
    public void testMultipleDelimiter() throws Exception {
        assertEquals(Calculator.add("//[*][%]\n1*2%3"), 6);
    }

    @Test
    public void testMultipleDelimiterAnyLength() throws Exception {
        assertEquals(Calculator.add("//[****][%%%%]\n1****2%%%%3"), 6);
    }
}
