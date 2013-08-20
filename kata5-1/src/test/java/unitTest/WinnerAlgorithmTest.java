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
    public void testXWinInRow() throws Exception
    {
        String[] arrayPlayer = {"X","X","X","O","O","","","",""};
        assertEquals("X", WinnerAlgorithm.check(arrayPlayer));
    }
}
