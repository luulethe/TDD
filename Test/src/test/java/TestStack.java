import org.junit.*;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/17/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestStack {
    @Test
    public void testEmptyStack() {
        Stack s = new Stack();
        assertEquals(s.size(), 0);
    }

    @Test
    public void testPushAElement() {
        Stack s = new Stack();
        s.push("a String");
        assertEquals(s.size(), 1);
    }

    @Test
    public void testPush() {
        Stack s = new Stack();
        s.push("a String");
        s.push("a String1");
        s.push("a String2");
        assertEquals(s.size(), 3);
        s.push("a String3");
        assertEquals(s.size(), 4);
    }

    @Test
    public void testTopNull() {
        Stack s = new Stack();
        String aString = s.top();
        assertEquals(aString, null);
    }

    @Test
    public void testTop() {
        Stack s = new Stack();
        s.push("a string");
        String aString = s.top();
        assertEquals(aString, "a string");
    }

    @Test(expected = StackEmptyException.class)
    public void testPopEmpty() throws Exception {
        Stack s = new Stack();
        String aString = s.pop();
        fail("Exception expected");
    }

    @Test
    public void testPop() throws Exception {
        Stack s = new Stack();
        s.push("a String");
        s.push("a String1");
        s.push("a String2");
        s.pop();
        assertEquals(s.size(), 2);
    }

    @Test
    public void testPopWithStackHavingAElement() throws Exception {
        Stack s = new Stack();
        s.push("a String");
        s.pop();
        assertEquals(s.size(), 0);
        assertTrue(s.isEmpty());
    }

    @Test
    public void testPopAndTop() throws Exception {
        Stack s = new Stack();
        s.push("a String");
        s.push("a String1");
        s.push("a String2");
        String aElement = s.top();
        String aElement1 = s.pop();
        assertEquals(aElement, aElement1);
    }

    @Test
    public void testPushAndPop() throws Exception {
        Stack s = new Stack();
        s.push("a String");
        s.push("a String1");
        s.push("a String2");
        assertEquals(s.pop(), "a String2");
        assertEquals(s.pop(), "a String1");
        assertEquals(s.pop(), "a String");
        assertTrue(s.isEmpty());
    }

    @Test
    public void testPushNotString() throws Exception {
        Stack s = new Stack();
        s.push(null);
        assertTrue(s.isEmpty());
    }

}
