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
    public void testEmptyString() {
        assertEquals(Calculator.add(""), 0);
    }

    @Test
    public void testOneNumber() {
        assertEquals(Calculator.add("1"), 1);
    }

    @Test
    public void testTwoNumber() {
        assertEquals(Calculator.add("1,2"), 3);
    }

    @Test
    public void testUnknowNumber() {
        assertEquals(Calculator.add("1,2,3"), 6);
    }

    @Test
    public void testHavingNewLine() {
        assertEquals(Calculator.add("1\n2,3"), 6);
    }

    @Test
    public void testHavingDifferenceDelimiter() {
        assertEquals(Calculator.add("//;\n1;2"), 3);
    }

    @Test
    public void testRaiseException() {
        try{
            Calculator.add("//;\n1;-2");
            fail("Exception expected");
        }catch (Exception e) {

        }
    }
}
