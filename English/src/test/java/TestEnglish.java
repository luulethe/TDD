import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/16/13
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestEnglish {
    static String[] units = {"zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine", "ten",
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};

    @Test
    public void testZeroToNineteen() {
        int i = 0;
        for (String s : units) {
            assertTrue(units[i].equals(English.numberToWords(i)));
            i += 1;
        }
    }

    @Test
    public void testRandomFrom20To99() {
        assertTrue("twenty one".equals(English.numberToWords(21)));
        assertTrue("thirty two".equals(English.numberToWords(32)));
        assertTrue("forty three".equals(English.numberToWords(43)));
        assertTrue("fifty six".equals(English.numberToWords(56)));
        assertTrue("sixty nine".equals(English.numberToWords(69)));
    }

    @Test
    public void testRandomFrom100to999() {
        assertTrue("one hundred".equals(English.numberToWords(100)));
        assertTrue("one hundred and twenty one".equals(English.numberToWords(121)));
        assertTrue("three hundred and twenty one".equals(English.numberToWords(321)));
        assertTrue("four hundred and forty one".equals(English.numberToWords(441)));
        assertTrue("nine hundred and ninety five".equals(English.numberToWords(995)));
    }

    @Test
    public void testRandomFrom1000to999999() {
        assertTrue("one thousand".equals(English.numberToWords(1000)));
        assertTrue("one hundred and twenty three thousand four hundred and fifty six".equals(English.numberToWords(123456)));
        assertTrue("two hundred and forty three thousand eight hundred and ninety six".equals(English.numberToWords(243896)));
        //assertTrue("one thousand".equals(English.numberToWords(1000)));
    }

    @Test
    public void testRandomFrom1000000to999999999() {
        assertTrue("one million".equals(English.numberToWords(1000000)));
        assertTrue("seven hundred and eighty nine million one hundred and twenty three thousand four hundred and fifty six".equals(English.numberToWords(789123456)));
    }

    @Test
    public void testRandomMoreThanOneBillion() {
        assertTrue("one billion".equals(English.numberToWords(1000000000)));
        assertTrue("one billion seven hundred and eighty nine million one hundred and twenty three thousand four hundred and fifty six".equals(English.numberToWords(1789123456)));
        //assertTrue("seven hundred and eighty nine million one hundred and twenty three thousand four hundred and fifty six".equals(English.numberToWords(789123456)));
    }
    @Test
    public void testNegativeNumber() {
        int i = 0;
        for (String s : units) {
            if (i> 0)
            assertTrue(("minus "+units[i]).equals(English.numberToWords(-i)));
            i += 1;
        }
    }

}
