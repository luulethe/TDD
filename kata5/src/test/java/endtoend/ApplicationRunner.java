package endtoend;

import com.qsoft.Main;
import com.qsoft.tictactoe.ui.view.FrameHistory;
import com.qsoft.tictactoe.ui.view.MainWindow;


/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:31 AM
 */
public class ApplicationRunner
{
    private TicTacToeDriver ticTacToeDriver;
    private HistoryDriver historyDriver;

    public void startGame()
    {
        Thread thread = new Thread("Test Application")
        {
            @Override
            public void run()
            {
                try
                {
                    Main.main(null);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        ticTacToeDriver = new TicTacToeDriver(4000);
        ticTacToeDriver.hasTitle(MainWindow.APPLICATION_TITLE);

    }

    public void newGame()
    {
        ticTacToeDriver.clickStartButton();        //To change body of created methods use File | Settings | File Templates.
    }

    public void endGame()
    {
        ticTacToeDriver.clickEndButton();
    }

    public void showsStatusStartGame()
    {
        ticTacToeDriver.hasStatusStartGame();
    }

    public void showsStatusEndGame()
    {
        ticTacToeDriver.hasStatusEndGame();
        //To change body of created methods use File | Settings | File Templates.
    }

    public void move(int indexCell)
    {
        ticTacToeDriver.clickCellNumber(indexCell);
    }

    public void close()
    {
        ticTacToeDriver.dispose();
        if (historyDriver !=null)
            historyDriver.dispose();
    }

    public void showsWinnerIsCross()
    {
        ticTacToeDriver.hasStatusWinner();
    }

    public void showCell(int indexCell, String namePlayer)
    {
        ticTacToeDriver.hasNamePlayerInCell(indexCell, namePlayer); //To change body of created methods use File | Settings | File Templates.
    }

    public void showsDrawStatus()
    {
        ticTacToeDriver.hasStatusDraw();
    }


    public void startShowHistory()
    {
        ticTacToeDriver.clickButtonHistory();
        historyDriver = new HistoryDriver(4000);
        historyDriver.hasTitle(FrameHistory.FRAME_HISTORY_NAME);
    }

    public void showsEmptyHistory()
    {
        historyDriver.hasColumnTitles();
        historyDriver.hasShowEmptyHistory();
    }

    public void showsHistory()
    {
        historyDriver.hasColumnTitles();
        historyDriver.hasShowHistory();
    }
}
