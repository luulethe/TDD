import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * User: luult
 * Date: 7/15/13
 * Time: 1:32 PM
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
    public void testInsertFirtList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        assertEquals(1, singleLinkedList.size());
    }

    @Test
    public void testReturnFirstNodeOfList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        Node firstNode = singleLinkedList.first();
        assertEquals(1, singleLinkedList.size());
        assertEquals(firstNode.getData(), o1);
    }

    @Test
    public void testReturnFirstNodeOfListWithEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node firstNode = singleLinkedList.first();
        assertEquals(null, firstNode);
    }

    @Test
    public void testReturnLastNodeOfList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node lastNode = singleLinkedList.last();
        assertEquals(2, singleLinkedList.size());
        assertEquals(lastNode.getData(), o1);
    }

    @Test
    public void testReturnLastNodeWithEmptyList()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Node lastNode = singleLinkedList.last();
        assertEquals(null, lastNode);
    }

    @Test
    public void testBeforeOfNode()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node lastNode = singleLinkedList.last();
        Node beforeLastNode = singleLinkedList.before(lastNode);
        assertEquals(beforeLastNode.getData(), o2);
    }

    @Test
    public void testBeforeOfFirstNode()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node firstNode = singleLinkedList.first();
        Node beforeFirstNode = singleLinkedList.before(firstNode);
        assertEquals(null ,beforeFirstNode);
    }

    @Test
    public void testBeforeOfNoExistingNode()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node node = new Node(new Integer(5));
        Node beforeFirstNode = singleLinkedList.before(node);
        assertEquals(null ,beforeFirstNode);
    }

    @Test
    public void testAfterOfNode()
    {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        Object o1 = new Integer(3);
        singleLinkedList.insertFirst(o1);
        Object o2 = new Integer(4);
        singleLinkedList.insertFirst(o2);

        Node firstNode = singleLinkedList.first();
        Node afterFirstNode = singleLinkedList.after(firstNode);
        assertEquals(afterFirstNode.getData(), o1);

        Node lastNode = singleLinkedList.last();
        Node afterLastNode = singleLinkedList.after(lastNode);
        assertEquals(null ,afterLastNode);

        Node node = new Node(new Integer(5));
        Node afterNode = singleLinkedList.after(node);
        assertEquals(null ,afterNode);

    }

}
