/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/5/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String text) {
        if (text.equals(""))
            return 0;
        String delimiterString = getDelimiter(text);
        String[] listNumber = getListNumber(text, delimiterString);
        return sumList(listNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    private static int sumList(String[] listNumber) {
        int sum = 0;

        for (String s : listNumber) {
            sum += Integer.parseInt(s);
        }
        return sum;  //To change body of created methods use File | Settings | File Templates.
    }

    private static String[] getListNumber(String text, String delimiterString) {
        String textNumber = text;
        if (text.startsWith("//"))
            textNumber = text.split("\n")[1];
        return textNumber.split(delimiterString);
    }

    private static String getDelimiter(String text) {
        String delimiterString = ",|\n";
        if (text.startsWith("//"))
            delimiterString = text.substring(2, 3) + "|\n";
        return delimiterString;
    }
}
