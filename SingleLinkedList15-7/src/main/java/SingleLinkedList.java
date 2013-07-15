import java.util.LinkedList;

/**
 * User: luult
 * Date: 7/15/13
 * Time: 1:34 PM
 */
public class SingleLinkedList
{
    LinkedList<Node> linkedList = new LinkedList<Node>();

    public int size()
    {
        return linkedList.size();
    }

    public void insertFirst(Object o1)
    {
        Node n = new Node(o1);
        linkedList.addFirst(n);
    }

    public Node first()
    {
        if (size() > 0)
        {
            return linkedList.getFirst();
        }
        else
        {
            return null;
        }
    }

    public Node last()
    {
        if (size() > 0)
        {
            return linkedList.getLast();
        }
        else
        {
            return null;
        }
    }

    public Node before(Node n)
    {
        int length = size();
        for (int i = 1; i < length; i++)
        {
            if (linkedList.get(i) == n)
            {
                return linkedList.get(i - 1);
            }
        }
        return null;
    }

    public Node after(Node n)
    {
        int length = size();
        for (int i = 0; i < length - 1; i++)
        {
            if (linkedList.get(i) == n)
            {
                return linkedList.get(i + 1);
            }
        }
        return null;
    }
}
