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
    @Test
    public void startGameThenMoveThenHasAWinnerInRow()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
        application.move(0);
        application.showCrossCell(0);
        application.move(4);
        application.showRoundCell(4);
        application.move(1);
        application.showCrossCell(1);
        application.move(5);
        application.showRoundCell(5);
        application.move(2);
        application.showCrossCell(2);

        application.showWinnerIsCross();

    }
    @Test
    public void startGameThenMoveThenHasAWinnerInColumn()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
        application.move(0);
        application.showCrossCell(0);
        application.move(4);
        application.showRoundCell(4);
        application.move(3);
        application.showCrossCell(3);
        application.move(5);
        application.showRoundCell(5);
        application.move(6);
        application.showCrossCell(6);

        application.showWinnerIsCross();

    }
    @Test
    public void startGameThenMoveThenHasAWinnerInCross()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
        application.move(0);
        application.showCrossCell(0);
        application.move(5);
        application.showRoundCell(5);
        application.move(4);
        application.showCrossCell(4);
        application.move(6);
        application.showRoundCell(6);
        application.move(8);
        application.showCrossCell(8);

        application.showWinnerIsCross();

    }

    @After
    public void close()
    {
        application.close();
    }
}
