package endtoend;

import com.qsoft.Main;
import com.qsoft.ui.FrameHistory;
import com.qsoft.ui.MainWindow;


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
        ticTacToeDriver = new TicTacToeDriver(1000);
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

    public void showStatusStartGame()
    {
        ticTacToeDriver.hasStatusStartGame();
    }

    public void showStatusEndGame()
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
    }

    public void showWinnerIsCross()
    {
        ticTacToeDriver.hasStatusWinner();
    }

    public void showCell(int indexCell, String namePlayer)
    {
        ticTacToeDriver.hasNamePlayerInCell(indexCell, namePlayer); //To change body of created methods use File | Settings | File Templates.
    }

    public void showDrawStatus()
    {
        ticTacToeDriver.hasStatusDraw();
    }


    public void startShowHistory()
    {
        ticTacToeDriver.clickButtonHistory();
        historyDriver = new HistoryDriver(1000);
        historyDriver.hasTitle(FrameHistory.FRAME_HISTORY_NAME);
    }

    public void showEmptyHistory()
    {
        historyDriver.hasColumnTitles();
        historyDriver.hasShowEmptyHistory();
    }
}
