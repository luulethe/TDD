import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/15/13                                      String negativeString = "";
 * <p/>
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class Calculator {


    public static int add(String text) throws Exception {
        List<String> listDilimiter = getDilimiter(text);
        String[] listNumber = getNumbers(text, listDilimiter);
        return sum(listNumber);
    }

    private static String[] getNumbers(String text, List<String> listDilimiter) {
        String dilimiterString = listDilimiter.get(0);
        int i = 0;
        for (String s : listDilimiter) {
            if (i > 0)
                dilimiterString += "|" + s;
            i++;
        }
        System.out.println(dilimiterString);
        if (text.startsWith("//")) {
            text = text.split("\n")[1];
        }
        System.out.println(text);
        if ("".equals(text))
            return new String[0];
        else
            return text.split(dilimiterString);
    }

    private static List<String> getDilimiter(String text) {
        List<String> list = new ArrayList<String>();
        if (!text.startsWith("//")) {
            list.add(",");
            list.add("\n");
        } else if (!text.startsWith("//["))
            list.add(text.substring(2, 3));
        else {
            String[] firstList = text.split("]");
            for (String s : firstList) {
                String[] secondList = s.split("\\[");
                if (secondList.length > 1)
                    list.add(normalize(secondList[1]));
            }
        }
        return list;
    }

    public static int sum(String[] listNumber) throws Exception {
        for (String s : listNumber) {
            System.out.println("s==" + s);
        }
        String negativeString = "";
        int sum = 0;
        for (String s : listNumber) {
            if (Integer.parseInt(s) < 0) {
                negativeString += " " + s;
            }
            if (Integer.parseInt(s) <= 1000)
                sum += Integer.parseInt(s);
        }
        if (!negativeString.equals("")) {
            throw new Exception("negatives not allowed:" + negativeString);
        }
        return sum;
    }

    private static String normalize(String s) {
        s = s.replaceAll("[*]", "\\\\*");
        s = s.replaceAll("[?]", "\\\\?");
        s = s.replaceAll("[+]", "\\\\+");
        return s;
    }
}
