/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/4/13
 * Time: 1:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String text) throws Exception {
        if (text.equals(""))
            return 0;
        String delimiterString = getDelimiter(text);
        String[] listNumber = getListNumber(text, delimiterString);
        return sum(listNumber);
    }

    private static int sum(String[] listNumber) throws Exception {
        int sum = 0;
        String negativeString = "";
        for (String s : listNumber) {
            if (Integer.parseInt(s) <= 1000)
                sum += Integer.parseInt(s);
            if (Integer.parseInt(s) < 0)
                negativeString += " " + s;
        }
        if (!negativeString.equals(""))
            throw new Exception("negatives not allowed" + negativeString);
        return sum;
    }

    private static String[] getListNumber(String text, String delimiterString) {
        String numberString = text;
        if (text.startsWith("//"))
            numberString = text.split("\n")[1];
        return numberString.split(delimiterString);
    }

    private static String getDelimiter(String text) {
        String delimiterString = ",|\n";
        if (text.startsWith("//"))
            delimiterString = text.substring(2, 3) + "|\n";
        return delimiterString;  //To change body of created methods use File | Settings | File Templates.
    }
}
