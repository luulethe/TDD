package com.qsoft.tictactoe.ui.utils;

/**
 * User: luult
 * Date: 8/20/13
 * Time: 8:09 AM
 */
public class WinnerAlgorithm
{
    public static String check(String[] arrayText)
    {
        for (int i = 0; i < 3; i++)
        {
            if (arrayText[3 * i].equals(arrayText[3 * i + 1]) && arrayText[3 * i + 1].equals(arrayText[3 * i + 2]))
            {
                return arrayText[3 * i];
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if (arrayText[i].equals(arrayText[i + 3]) && arrayText[i + 3].equals(arrayText[i + 6]))
            {
                return arrayText[i];
            }
        }
        return "";
    }
}
