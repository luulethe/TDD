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
    private static final String CROSS_PLAYER = "X";
    private static final String ROUND_PLAYER = "O";

    @Test
    public void startGameThenExit()
    {
        initializeGame();
        application.endGame();
        application.showStatusEndGame();
    }

    private void initializeGame()
    {
        application.startGame();
        application.newGame();
        application.showStatusStartGame();
    }

    @Test
    public void startGameThenExitAfterMovingOneStep()
    {
        initializeGame();
        application.move(1);
        application.showCell(1, CROSS_PLAYER);
        application.endGame();
        application.showStatusEndGame();
    }

    @Test
    public void startGameThenExitAfterMovingMoreThanOneStep()
    {
        initializeGame();
        application.move(1);
        application.showCell(1, CROSS_PLAYER);
        application.move(2);
        application.showCell(2, ROUND_PLAYER);
        application.move(3);
        application.showCell(3, CROSS_PLAYER);
        application.endGame();
        application.showStatusEndGame();
    }

    @Test
    public void startGameThenMoveThenHasAWinnerInRow()
    {
        initializeGame();
        application.move(0);
        application.showCell(0, CROSS_PLAYER);
        application.move(4);
        application.showCell(4, ROUND_PLAYER);
        application.move(1);
        application.showCell(1, CROSS_PLAYER);
        application.move(5);
        application.showCell(5, ROUND_PLAYER);
        application.move(2);
        application.showCell(2, CROSS_PLAYER);

        application.showWinnerIsCross();

    }

    @Test
    public void startGameThenMoveThenHasAWinnerInColumn()
    {
        initializeGame();
        application.move(0);
        application.showCell(0, CROSS_PLAYER);
        application.move(4);
        application.showCell(4, ROUND_PLAYER);
        application.move(3);
        application.showCell(3, CROSS_PLAYER);
        application.move(5);
        application.showCell(5, ROUND_PLAYER);
        application.move(6);
        application.showCell(6, CROSS_PLAYER);

        application.showWinnerIsCross();

    }

    @Test
    public void startGameThenMoveThenHasAWinnerInCross()
    {
        initializeGame();
        application.move(0);
        application.showCell(0, CROSS_PLAYER);
        application.move(5);
        application.showCell(5, ROUND_PLAYER);
        application.move(4);
        application.showCell(4, CROSS_PLAYER);
        application.move(6);
        application.showCell(6, ROUND_PLAYER);
        application.move(8);
        application.showCell(8, CROSS_PLAYER);

        application.showWinnerIsCross();

    }
//    @Test
//    public void startGameThenMoveWhenFullMap()
//    {
//
//    }

    @After
    public void close()
    {
        application.close();
    }
}
