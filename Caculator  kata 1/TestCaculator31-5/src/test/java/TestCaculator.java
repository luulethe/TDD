import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/31/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCaculator {
    @Test
    public void testEmptyString() throws Exception {
        assertEquals(0, Caculator.add(""));
    }

    @Test
    public void testOneNumber() throws Exception {
        assertEquals(1, Caculator.add("1"));
    }

    @Test
    public void testTwoNumber() throws Exception {
        assertEquals(10, Caculator.add("1,9"));
    }

    @Test
    public void testUnknowNumber() throws Exception {
        assertEquals(10, Caculator.add("1,2,3,4"));
    }

    @Test
    public void testHavingNewLine() throws Exception {
        assertEquals(6, Caculator.add("1\n2,3"));
    }

    @Test
    public void testHavingDifferenceDelimeters() throws Exception {
        assertEquals(3, Caculator.add("//;\n1;2"));
    }

    @Test
    public void testRaiseException() throws Exception {
        try {
            Caculator.add("//;\n1;-2");
            fail("Exception expected");
        } catch (Exception e) {

        }
    }

    @Test
    public void testRaiseExceptionMessage() {
        try {
            Caculator.add("//;\n-1;-2");
            fail("Exception expected");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -1 -2");
        }
    }
}
