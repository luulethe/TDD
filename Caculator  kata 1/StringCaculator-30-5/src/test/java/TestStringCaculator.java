import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/30/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStringCaculator {
    @Test
    public void TestEmptyString() throws Exception {
        assertEquals(0, StringCaculator.add(""));
    }

    @Test
    public void TestOneNumber() throws Exception {
        assertEquals(1, StringCaculator.add("1"));
    }

    @Test
    public void TestTwoNumber() throws Exception {
        assertEquals(3, StringCaculator.add("1,2"));
    }

    @Test
    public void TestUnknownNumber() throws Exception {
        assertEquals(6, StringCaculator.add("1,2,3"));
    }

    @Test
    public void TestHaveNewLine() throws Exception {
        assertEquals(10, StringCaculator.add("1\n2,3,4"));
    }

    @Test
    public void TestDifferenceDelimiters() throws Exception {
        assertEquals(3, StringCaculator.add("//;\n1;2"));
    }

    @Test
    public void TestCatchNegativeException() {
        try {
            assertEquals(3, StringCaculator.add("//;\n-1;2"));
            fail("Exception expected");
        } catch (Exception e) {
            //assertEquals(e.getMessage(),"negatives not allowed -1");
        }
    }

    @Test
    public void TestCatchMutipleNegativeException() {
        try {
            assertEquals(3, StringCaculator.add("//;\n-1;-2;3"));
            fail("Exception expected");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -1 -2");
        }
    }
}
