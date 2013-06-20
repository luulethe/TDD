package exceptionPackage;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/20/13
 * Time: 9:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class DoNotExitAccountException extends Exception {
    public DoNotExitAccountException(String s) {
        super(s);
    }
}
