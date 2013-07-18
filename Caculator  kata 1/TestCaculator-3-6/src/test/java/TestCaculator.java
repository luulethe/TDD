import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/3/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestCaculator {
    @Test
    public void testEmptyString() throws Exception {
        assertEquals(0, Caculator.add(""));
    }

    @Test
    public void TestOneNumber() throws Exception {
        assertEquals(1, Caculator.add("1"));
    }

    @Test
    public void TestTwoNumber() throws Exception {
        assertEquals(3, Caculator.add("1,2"));
    }

    @Test
    public void TestUnknownNumber() throws Exception {
        assertEquals(10, Caculator.add("1,2,3,4"));
    }

    @Test
    public void TestHavingNewLine() throws Exception {
        assertEquals(6, Caculator.add("1\n2,3"));
    }

    @Test
    public void TestHavingDifferenceDelimiter() throws Exception {
        assertEquals(3, Caculator.add("//;\n1;2"));
    }

    @Test
    public void TestRaiseException() {
        try {
            Caculator.add("//;\n1;-2");
            fail("Exception expected");
        } catch (Exception e) {

        }
    }

    @Test
    public void TestMessageException() {
        try {
            Caculator.add("//;\n1;-2");
            fail("Exception expected");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "negatives not allowed -2");

        }
    }

    @Test
    public void TestIgnoreMoreThan1000() throws Exception {
        assertEquals(2, Caculator.add("//;\n1001;2"));
    }

    @Test
    public void TestDelimiterAnyLength() throws Exception {
        assertEquals(6, Caculator.add("//[***]\n1***2***3"));
    }

    @Test
    public void TestMutipleDelimiter() throws Exception {
        assertEquals(6, Caculator.add("//[*][%]\n1*2%3"));

    }

    @Test
    public void TestMutipleDelimiterAnyLength() throws Exception {
        assertEquals(6, Caculator.add("//[**][%%]\n1**2%%3"));
    }
}
