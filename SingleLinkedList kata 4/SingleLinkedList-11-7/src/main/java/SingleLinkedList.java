import java.util.LinkedList;
import java.util.List;

/**
 * User: luult
 * Date: 7/11/13
 * Time: 1:44 PM
 */
public class SingleLinkedList
{
    List<Node> linkList = new LinkedList<Node>();

    public int size()
    {
        return 0;
    }

    public void insertFirst(Object o)
    {
        Node n = new Node(o);
        linkList.add(n);//To change body of created methods use File | Settings | File Templates.
    }
}
