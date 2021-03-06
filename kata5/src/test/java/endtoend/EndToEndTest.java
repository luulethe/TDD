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

    private void initializeGame()
    {
        application.startGame();
        application.newGame();
        application.showsStatusStartGame();
    }

    @Test
    public void startGameThenExit()
    {
        initializeGame();
        application.endGame();
        application.showsStatusEndGame();
    }

    @Test
    public void startGameThenExitAfterMovingOneStep()
    {
        initializeGame();
        application.move(1);
        application.showCell(1, CROSS_PLAYER);
        application.endGame();
        application.showsStatusEndGame();
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
        application.showsStatusEndGame();
    }

    @Test
    public void startGameThenMoveThenHasAWinnerInRow()
    {
        initializeGame();
        application.move(0);
        application.move(4);
        application.move(1);
        application.move(5);
        application.move(2);

        application.showsWinnerIsCross();

    }

    @Test
    public void startGameThenMoveThenHasAWinnerInColumn()
    {
        initializeGame();
        application.move(0);
        application.move(4);
        application.move(3);
        application.move(5);
        application.move(6);

        application.showsWinnerIsCross();

    }

    @Test
    public void startGameThenMoveThenHasAWinnerInCross()
    {
        initializeGame();
        application.move(0);
        application.move(5);
        application.move(4);
        application.move(6);
        application.move(8);

        application.showsWinnerIsCross();

    }

    @Test
    public void startGameThenMoveWhenFullMap()
    {
        initializeGame();
        application.move(0);
        application.move(1);
        application.move(2);
        application.move(3);
        application.move(4);
        application.move(6);
        application.move(5);
        application.move(8);
        application.move(7);

        application.showsDrawStatus();

    }

    @Test
    public void showHistoryWhenNoGameHappen()
    {
        application.startGame();
        application.startShowHistory();
        application.showsEmptyHistory();
    }

    @Test
    public void showHistoryWhenEndGame()
    {
        startGameThenExitAfterMovingMoreThanOneStep();
        application.startShowHistory();
        application.showsEmptyHistory();
    }

    @Test
    public void showHistoryWhenOneGameHappen()
    {
        startGameThenMoveThenHasAWinnerInColumn();
        application.startShowHistory();
        application.showsHistory();
    }

    @After
    public void close()
    {
        application.close();
    }
}
