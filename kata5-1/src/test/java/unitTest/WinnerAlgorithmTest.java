package unitTest;

import com.qsoft.tictactoe.ui.utils.WinnerAlgorithm;
import endtoend.ApplicationRunner;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: luult
 * Date: 8/20/13
 * Time: 8:10 AM
 */
public class WinnerAlgorithmTest
{
    @Test
    public void testXWinInRow()
    {
        String[] arrayPlayer = {"X","X","X","O","O","","","",""};
        assertEquals("X", WinnerAlgorithm.check(arrayPlayer));
    }

    @Test
    public void testOWinInColumn()
    {
        String[] arrayPlayer = {"O","X","X","O","","","O","",""};
        assertEquals("O", WinnerAlgorithm.check(arrayPlayer));
    }

    @Test
    public void testXWinInCrossFromLeftTopToRightDown()
    {
        String[] arrayPlayer = {"X","O","O","","X","","","","X"};
        assertEquals("X", WinnerAlgorithm.check(arrayPlayer));
    }

    @Test
    public void testOWinInCrossFromLeftDownToRightTop()
    {
        String[] arrayPlayer = {"X","X","O","","O","","O","",""};
        assertEquals("O", WinnerAlgorithm.check(arrayPlayer));
    }

    @Test
    public void testNoWinner()
    {
        String[] arrayPlayer = {"X","X","O","","X","","O","",""};
        assertEquals("", WinnerAlgorithm.check(arrayPlayer));
    }
}
