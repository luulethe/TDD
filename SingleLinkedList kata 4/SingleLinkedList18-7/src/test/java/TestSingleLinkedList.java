import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: luult
 * Date: 7/18/13
 * Time: 9:36 PM
 */
public class TestSingleLinkedList
{
    @Test
    public void TestCreateEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        assertEquals(0, singleLinkedList.size());
    }

    @Test
    public void TestInsertFirst()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertFirst(new Integer(3));
        assertEquals(1, singleLinkedList.size());
    }

    @Test
    public void TestGetFirst()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertFirst(new Integer(3));
        singleLinkedList.insertFirst(new Integer(4));

        assertEquals(4, singleLinkedList.first().get());
    }
}
