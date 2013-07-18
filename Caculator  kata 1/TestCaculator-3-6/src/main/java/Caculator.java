/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 6/3/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class Caculator {
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
            if (Integer.parseInt(s) < 0)
                negativeString += " " + s;
            if (Integer.parseInt(s) <= 1000)
                sum += Integer.parseInt(s);
        }
        if (!negativeString.equals(""))
            throw new Exception("negatives not allowed" + negativeString);
        return sum;
    }

    private static String[] getListNumber(String text, String delimiterString) {
        String numberString = text;

        if (text.startsWith("//")) {
            numberString = text.split("\n")[1];
        }
        return numberString.split(delimiterString);
    }

    private static String getDelimiter(String text) {

        String delimiterString = "\n|,";
        if (!text.startsWith("//")) {
            return delimiterString;
        }
        if (!text.startsWith("//[")) {
            delimiterString = "\n|" + text.substring(2, 3);
        } else {
            String[] listDelimiter = text.split("\n")[0].split("]");
            delimiterString = nomalize(listDelimiter[0].split("\\[")[1]);
            int i = 0;
            for (String s : listDelimiter) {
                i++;
                if (i > 1)
                    delimiterString += "|" + nomalize(s.split("\\[")[1]);
            }

        }
        return delimiterString;
    }

    private static String nomalize(String s) {
        s = s.replaceAll("[*]", "\\\\*");
        s = s.replaceAll("[?]", "\\\\?");
        return s.replaceAll("[+]", "\\\\+");
    }
}