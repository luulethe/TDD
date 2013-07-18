/**
 * Created with IntelliJ IDEA.
 * User: luu
 * Date: 5/16/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class English {
    static String[] units = {"zero","one","two","three","four",
            "five","six","seven","eight","nine","ten",
            "eleven","twelve","thirteen","fourteen","fifteen",
            "sixteen","seventeen","eighteen","nineteen"} ;
    static String[] tens = {"","","twenty","thirty","forty","fifty",
            "sixty","seventy","eighty","ninety"};
    public static String numberToWords(int i) {
        if (i < 0) return "minus " + numberToWords(-i);
        if (i < 20) return units[i];
        if (i < 100) return tens[i/10] + ((i % 10 > 0)? " " + numberToWords(i % 10):"") ;
        if (i < 1000) return units[i/100] + " hundred" + ((i % 100 > 0)?" and " + numberToWords(i % 100):"");
        if( i < 1000000) return numberToWords(i / 1000) + " thousand" + ((i % 1000 > 0)? " " + numberToWords(i % 1000):"") ;
        if( i< 1000000000) return numberToWords(i / 1000000) + " million" + ((i % 1000000 > 0)? " " + numberToWords(i % 1000000):"") ;
        return    numberToWords(i / 1000000000) + " billion" + ((i % 1000000000 > 0)? " " + numberToWords(i % 1000000000):"") ;
     }
}
