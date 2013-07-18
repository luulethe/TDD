import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/17/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stack {
    List<String> list;

    Stack() {
        list = new ArrayList<String>();
    }

    public int size() {
        return list.size();  //To change body of created methods use File | Settings | File Templates.
    }

    public void push(String s) {
        if (s != null)
            list.add(s);
    }

    public String top() {
        int length = size();
        if (length > 0)
            return list.get(length - 1);
        else return null;
    }

    public String pop() throws Exception {
        int length = size();
        if (length <= 0)
            throw new StackEmptyException("Stack empty");
        String temp = list.get(length - 1);
        list.remove(length - 1);
        return temp;
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
