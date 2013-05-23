import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/16/13
 * Time: 1:41 PM
 * To change this template use File | Settings | File Templates.
 */
//import static ch.lambdaj.Lambda.*;
public class thu {
    public static void abd(String s) {
        System.out.println(s);
    }

    private static String normalize(String s) {
        s = s.replaceAll("[*]", "\\\\*");
        s = s.replaceAll("\\?", "\\?");
        s = s.replaceAll("\\+", "\\+");
        return s;
    }

    public static void main(String[] args) {
        System.out.println(normalize("***"));
    }
}




