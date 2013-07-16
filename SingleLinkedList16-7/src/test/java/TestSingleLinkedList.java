import org.junit.Test;

import static org.junit.Assert.*;

/**
 * User: luult
 * Date: 7/16/13
 * Time: 1:31 PM
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
    public void testInsertFirst()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);

        assertEquals(1, singleLinkedList.size());
    }

    @Test
    public void testGetFirst()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);

        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node n = singleLinkedList.first();

        assertEquals(o2, n.get());
    }

    @Test
    public void testGetFirstWithEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node n = singleLinkedList.first();

        assertEquals(null, n);
    }

    @Test
    public void testGetLast()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);

        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node n = singleLinkedList.last();

        assertEquals(o1, n.get());
    }

    @Test
    public void testGetLastWithEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node n = singleLinkedList.last();

        assertEquals(null, n);
    }

    @Test
    public void testGetBefore()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);

        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node n = singleLinkedList.last();
        Node beforeLastNode = singleLinkedList.before(n);

        assertEquals(o1, n.get());
    }

    @Test
    public void testGetBeforeOfFistNode()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);

        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node n = singleLinkedList.first();
        Node beforeFirstNode = singleLinkedList.before(n);

        assertEquals(null, beforeFirstNode);
    }

    @Test
    public void testGetBeforeOfNotExistingNode()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);

        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node n = new Node(new Integer(6));
        Node beforeFirstNode = singleLinkedList.before(n);

        assertEquals(null, beforeFirstNode);
    }
}
