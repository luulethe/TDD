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
    public void testUnknownNumber() {
        assertEquals(Calculator.add("1,2,3,4,5"), 15);
        assertEquals(Calculator.add("1,2,3,4,50"), 60);
    }

    @Test
    public void testHavingNewLine() {
        assertEquals(Calculator.add("1\n,2,3,4,5"), 15);
    }
}
