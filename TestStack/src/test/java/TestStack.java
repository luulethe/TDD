import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/29/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStack {
    @Test
    public void TestIsEmpty() {
        Stack s = new Stack();
        assertTrue(s.isEmpty());
    }

    @Test
    public void TestRaiseExceptionTop() {
        Stack s = new Stack();
        try {
            s.top();
            fail("exception excepted");
        } catch (Exception e) {
            assertTrue(e.getClass().toString().equals("class StackEmptyException"));
            //System.out.println(e.getClass().toString().equals("class StackEmptyException"));
        }
    }

    @Test
    public void TestRaiseExceptionPop() {
        Stack s = new Stack();
        try {
            s.top();
            fail("exception excepted");
        } catch (Exception e) {
            assertTrue(e.getClass().toString().equals("class StackEmptyException"));
            //System.out.println(e.getClass().toString().equals("class StackEmptyException"));
        }
    }

    @Test
    public void TestPush() {
        Stack s = new Stack();
        s.push("String 1");
        try {
            String topElement = s.top();
            assertTrue(topElement.equals("String 1"));
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }

        assertFalse(s.isEmpty());
    }

    @Test
    public void TestPop() {
        Stack s = new Stack();
        s.push("String 1");
        s.push("String 2");
        try {
            String firstElement = s.pop();
            String secondElement = s.pop();
            assertTrue(firstElement.equals("String 2"));
            assertTrue(secondElement.equals("String 1"));
            s.pop();
            fail("Exception excepted");
        } catch (Exception e) {
            System.out.println(e.toString());
            //e.printStackTrace();
        }
    }

    @Test
    public void testNull() {
        Stack s = new Stack();
        s.push(null);
        try {
            String firstElement = s.pop();
            assertTrue(firstElement == null);
        } catch (StackEmptyException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStillUseStackWhenHavingException() {
        Stack s = new Stack();
        try {
            s.pop();
        } catch (StackEmptyException e) {

        }
        try {
            s.push("string 1");
            assertTrue(s.pop().equals("string 1"));
        } catch (StackEmptyException r) {

        }
    }

}
