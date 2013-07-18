import sun.net.idn.StringPrep;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/31/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Caculator {
    public static int add(String text) throws Exception {
        if (text.equals(""))
            return 0;
        String delimiterString = getDelimiterString(text);
        String[] listNumber = getListNumber(text, delimiterString);
        return sumList(listNumber);
    }

    private static int sumList(String[] listNumber) throws Exception {
        int sum = 0;
        String negativeString = "";
        for (String s : listNumber) {
            if (Integer.parseInt(s) < 0)
                negativeString += " " + s;
            sum += Integer.parseInt(s);
        }
        if (!negativeString.equals(""))
            throw new Exception("negatives not allowed" + negativeString);
        return sum;

    }

    private static String[] getListNumber(String text, String delimiterString) {
        String numberString = null;
        if (text.startsWith("//"))
            numberString = text.split("\n")[1];
        else
            numberString = text;
        return numberString.split(delimiterString);
    }

    private static String getDelimiterString(String text) {
        String delimiterString = null;
        if (text.startsWith("//"))
            delimiterString = text.substring(2, 3) + "|,";
        else
            delimiterString = "\n|,";
        return delimiterString;
    }
}