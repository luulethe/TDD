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
        assertEquals(Calculator.add(""),0) ;
    }
    @Test
    public void testOneNumber() {
        assertEquals(Calculator.add("1"),1) ;
    }

    @Test
    public void testTwoNumber() {
        assertEquals(Calculator.add("1,2"),3) ;
    }
}
