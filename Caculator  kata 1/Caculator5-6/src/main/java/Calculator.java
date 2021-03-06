import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/5/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {
    public static int add(String text) throws Exception {
        if (text.equals(""))
            return 0;
        String delimiterString = getDelimiter(text);
        String[] listNumber = getListNumber(text, delimiterString);
        return sumList(listNumber);
    }

    private static int sumList(String[] listNumber) throws Exception {
        int sum = 0;
        String negativeString = "";
        for (String s : listNumber) {
            if (Integer.parseInt(s) <= 1000)
                sum += Integer.parseInt(s);
            if (Integer.parseInt(s) < 0) {
                negativeString += " " + s;
            }
        }
        if (!negativeString.equals(""))
            throw new Exception("negatives not allowed" + negativeString);
        return sum;
    }

    private static String[] getListNumber(String text, String delimiterString) {
        String textNumber = text;
        if (text.startsWith("//"))
            textNumber = text.split("\n")[1];
        return textNumber.split(delimiterString);
    }

    private static String getDelimiter(String text) {
        String delimiterString = ",|\n";
        if (text.startsWith("//[")) {
            delimiterString = "\n";
            String[] listDelimiter = text.split("\\[");
            int i = 0;
            for (String s : listDelimiter) {
                i++;
                if (i > 1) {
                    delimiterString += "|" + Pattern.quote(s.split("]")[0]);
                }
            }
        } else if (text.startsWith("//"))
            delimiterString = text.substring(2, 3) + "|\n";
        return delimiterString;
    }
}
