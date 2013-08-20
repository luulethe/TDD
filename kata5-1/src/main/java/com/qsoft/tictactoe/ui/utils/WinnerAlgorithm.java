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
        if (arrayText[0].equals(arrayText[4]) && arrayText[4].equals(arrayText[8]))
        {
            return arrayText[0];
        }
        if (arrayText[2].equals(arrayText[4]) && arrayText[4].equals(arrayText[6]))
        {
            return arrayText[2];
        }


        return "";
    }
}
