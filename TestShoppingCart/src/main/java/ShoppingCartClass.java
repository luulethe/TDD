import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/29/13
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class ShoppingCartClass implements  ShoppingCart {
    @Override
    public void addItems(Item anItem, int quantity) throws NegativeCountException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteItems(Item anItem, int quantity) throws NegativeCountException, NoSuchItemException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int itemCount() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Iterator iterator() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
