/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/29/13
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 */
public interface StackExercise {
    /**
     * Return and remove the most recent item from
     * the top of the stack.
     * Throws StackEmptyException
     * if the stack is empty
     */
    public String pop() throws StackEmptyException;

    /**
     * Add an item to the top of the stack.
     */
    public void push(String item);

    /**
     * Return but do not remove the most recent
     * item from the top of the stack.
     * Throws StackEmptyException
     * if the stack is empty
     */
    public String top() throws StackEmptyException;

    /**
     * Returns true if the stack is empty.
     */
    public boolean isEmpty();
}