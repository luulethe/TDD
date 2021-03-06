package endtoend;

import com.qsoft.tictactoe.Main;
import com.qsoft.tictactoe.ui.view.FrameHistory;
import com.qsoft.tictactoe.ui.view.MainWindow;

/**
 * User: luult
 * Date: 8/16/13
 * Time: 8:20 AM
 */
public class ApplicationRunner
{
    private TicTacToeDriver ticTacToeDriver;
    private HistoryDriver historyDriver;

    public void startApplication()
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

    public void startAGame()
    {
        ticTacToeDriver.clickStartButton();
    }

    public void showsStatusStartGame()
    {
        ticTacToeDriver.hasStatusStartGame();
    }

    public void endGame()
    {
        ticTacToeDriver.clickStopButton();
    }

    public void showsStatusEndGame()
    {
        ticTacToeDriver.hasStatusEndGame();
    }

    public void move(int index)
    {
        ticTacToeDriver.clickCell(index);
    }

    public void close()
    {
        ticTacToeDriver.dispose();
        if (historyDriver != null)
        {
            historyDriver.dispose();
        }
    }

    public void showsCellIs(int index, String namePlayer)
    {
        ticTacToeDriver.hasLabelInButton(index, namePlayer);
    }

    public void showsXWon()
    {
        ticTacToeDriver.hasStatusXWin();
    }

    public void showsNoWinner()
    {
        ticTacToeDriver.hasStatusNoWinner();
    }

    public void startHistory()
    {
        ticTacToeDriver.clickHistoryButton();
        historyDriver = new HistoryDriver(4000);
        historyDriver.hasTitle(FrameHistory.FRAME_HISTORY_NAME);
    }

    public void showsEmptyHistory()
    {
        historyDriver.hasColumnTitle();
        historyDriver.hasShowEmptyHistory();
    }

    public void showsHistoryWhenAGameHappen(String index, String firstPlayer, String winner, String steps)
    {
        historyDriver.hasColumnTitle();
        historyDriver.hasShowHistoryAGameHappen(index, firstPlayer, winner, steps);
    }
}
