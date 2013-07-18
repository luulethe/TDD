import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/30/13
 * Time: 2:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCaculator {
    public static int add(String text) throws Exception {
        if (text == "")
            return 0;
        String delimiter = null;
        String textNumber = null;
        if (text.startsWith("//")) {
            delimiter = text.substring(2, 3) + "|\n";
            textNumber = text.split("\n")[1];
        } else {
            delimiter = ",|\n";
            textNumber = text;
        }
        String[] listNumber = null;

        listNumber = textNumber.split(delimiter);
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
}