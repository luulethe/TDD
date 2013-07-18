import java.util.LinkedList;

/**
 * User: luult
 * Date: 7/18/13
 * Time: 9:38 PM
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
        linkedList.addFirst(n);//To change body of created methods use File | Settings | File Templates.
    }

    public Node first()
    {
        return linkedList.get(0);
    }
}
