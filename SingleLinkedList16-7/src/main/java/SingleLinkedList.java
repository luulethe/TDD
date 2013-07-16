import java.util.LinkedList;

/**
 * User: luult
 * Date: 7/16/13
 * Time: 1:32 PM
 */
public class SingleLinkedList
{
    LinkedList<Node> linkedList = new LinkedList<Node>();

    public int size()
    {
        return linkedList.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public void insertFirst(Object o1)
    {
        Node n = new Node(o1);
        linkedList.addFirst(n);
    }

    public Node first()
    {
        if (size() == 0)
        {
            return null;
        }
        else
        {
            return linkedList.get(0);
        }
    }

    public Node last()
    {
        if (size() == 0)
        {
            return null;
        }
        else
        {
            return linkedList.getLast();
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
}
