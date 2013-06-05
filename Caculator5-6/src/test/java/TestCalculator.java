import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/5/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCalculator {
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
    public void testUnknownNumber() throws Exception {
        assertEquals(Calculator.add("1,2,3,4,5"), 15);
        assertEquals(Calculator.add("1,2,3,4,50"), 60);
    }

    @Test
    public void testHavingNewLine() throws Exception {
        assertEquals(Calculator.add("1\n2,3,4,5"), 15);
    }

    @Test
    public void testDifferenceDelimiters() throws Exception {
        assertEquals(Calculator.add("//;\n1;2"), 3);
    }

    @Test
    public void testRaiseException() {
        try {
            Calculator.add("//;\n1;-2");
            fail("Exception excepted");
        } catch (Exception e) {

        }
    }

    @Test
    public void testMessageException() {
        try {
            Calculator.add("//;\n1;-2");
            fail("Exception excepted");
        } catch (Exception e) {
            assertEquals(e.getMessage(),"negatives not allowed -2");
        }
    }

    @Test
    public void testIgnoreMore1000() throws Exception {
        assertEquals(Calculator.add("//;\n1;2000;2"), 3);
    }

    @Test
    public void testDelimiterAnyLength() throws Exception {
        assertEquals(Calculator.add("//[***]\\n1***2***3"), 6);
    }
}
