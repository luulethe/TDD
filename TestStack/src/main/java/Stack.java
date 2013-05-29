import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/29/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class Stack implements StackExercise {
    List<String> list = new ArrayList<String>();

    @Override
    public String pop() throws StackEmptyException {
        String topElement = null;
        try {
            topElement = top();
        } catch (StackEmptyException e) {
            throw e;
        }
        catch (Exception e){

        }
        list.remove(topElement);
        return topElement;
    }

    @Override
    public void push(String item) {
        list.add(item);
    }

    @Override
    public String top() throws StackEmptyException {
        if (list.isEmpty())  throw new StackEmptyException();
        return list.get(list.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
