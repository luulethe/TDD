import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: luult
 * Date: 7/12/13
 * Time: 1:52 PM
 */
public class TestSingleLinkedList
{
    @Test
    public void testCreateEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        assertEquals(0, singleLinkedList.size());
    }
    @Test
    public  void testCreateListFromArray()
    {
        Object o1 = new Integer(1);
        Object o2 = new Integer(2);
        Object[] arrayObjects = { o1, o2};
    }
}
