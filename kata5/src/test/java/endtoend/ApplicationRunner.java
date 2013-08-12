package endtoend;

import com.qsoft.Main;
import com.qsoft.ui.MainWindow;


/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:31 AM
 */
public class ApplicationRunner
{
    private TicTacToeDriver driver;
    public void startGame()
    {
        Thread thread = new Thread("Test Application") {
            @Override public void run() {
                try {
                    Main.main(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        driver = new TicTacToeDriver(1000);
        driver.hasTitle(MainWindow.APPLICATION_TITLE);
    }
    public void newGame()
    {
        driver.clickStartButton();        //To change body of created methods use File | Settings | File Templates.
    }

    public void endGame()
    {
        driver.clickEndButton();
    }

    public void showStatusStartGame()
    {
         driver.hasStatusStartGame();
    }

    public void showStatusEndGame()
    {
        driver.hasStatusEndGame();
        //To change body of created methods use File | Settings | File Templates.
    }

    public void move(int indexCell)
    {
        driver.clickCellNumber(indexCell);
    }

    public void showCrossCell(int indexCell)
    {
        driver.hasCrossInCell(indexCell);
    }

    public void showRoundCell(int indexCell)
    {
        driver.hasRoundInCell(indexCell);
    }

    public void close()
    {
        driver.dispose();
    }
}
