import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: luult
 * Date: 7/11/13
 * Time: 1:45 PM
 */

public class TestSingleLinkedList
{
    //1
    @Test
    public void testEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        assertEquals(0, singleLinkedList.size());
    }

    //2
    @Test
    public void testInsertFirstListWithEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o = new Object();
        singleLinkedList.insertFirst(o);
        assertEquals(1, singleLinkedList.size());
    }
//    @Test
//    public
}
