package endtoend;

import org.junit.After;
import org.junit.Test;

/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:29 AM
 */
public class EndToEndTest
{
    private final ApplicationRunner application = new ApplicationRunner();
    @Test
    public  void startGameThenExit()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
        application.endGame();
        application.showStatusEndGame();
    }

    @Test
    public void startGameThenExitAfterMovingOneStep()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
        application.move(1);
        application.showCrossCell(1);
        application.endGame();
        application.showStatusEndGame();
    }

    @Test
    public void startGameThenExitAfterMovingMoreThanOneStep()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
        application.move(1);
        application.showCrossCell(1);
        application.move(2);
        application.showRoundCell(2);
        application.move(3);
        application.showCrossCell(3);
        application.endGame();
        application.showStatusEndGame();
    }

    @After
    public void close()
    {
        application.close();
    }
}
