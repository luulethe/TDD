/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/4/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String text) {
        if (text.equals(""))
            return 0;
        String[] listNumber = text.split(",|\n");
        int sum = 0;
        for(String s : listNumber) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
