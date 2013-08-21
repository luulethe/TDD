package endtoend;

import org.junit.After;
import org.junit.Test;

/**
 * User: luult
 * Date: 8/16/13
 * Time: 8:17 AM
 */
public class EndToEndTest
{
    private final ApplicationRunner applicationRunner = new ApplicationRunner();
    private static final String CROSS_PLAYER = "X";
    private static final String ROUND_PLAYER = "O";


    @Test
    public void startGameThenExit()
    {
        applicationRunner.startApplication();
        applicationRunner.startAGame();

        applicationRunner.showsStatusStartGame();
        applicationRunner.endGame();
        applicationRunner.showsStatusEndGame();
    }

    @Test
    public void startGameThenExitAfterMovingSomeSteps()
    {
        applicationRunner.startApplication();
        applicationRunner.startAGame();

        applicationRunner.move(1);
        applicationRunner.move(2);
        applicationRunner.move(3);

        applicationRunner.endGame();
        applicationRunner.showsStatusEndGame();
    }

    @Test
    public void XAndOTurnMoveAround()
    {
        applicationRunner.startApplication();
        applicationRunner.startAGame();

        applicationRunner.move(1);
        applicationRunner.showsCellIs(1, CROSS_PLAYER);
        applicationRunner.move(2);
        applicationRunner.showsCellIs(2, ROUND_PLAYER);
        applicationRunner.move(3);
        applicationRunner.showsCellIs(3, CROSS_PLAYER);
        applicationRunner.move(4);
        applicationRunner.showsCellIs(4, ROUND_PLAYER);

        applicationRunner.endGame();
        applicationRunner.showsStatusEndGame();
    }

    @Test
    public void startANewGameThenMoveThenHasAWinner()
    {
        applicationRunner.startApplication();
        applicationRunner.startAGame();

        applicationRunner.move(0);
        applicationRunner.move(3);
        applicationRunner.move(1);
        applicationRunner.move(4);
        applicationRunner.move(2);

        applicationRunner.showsXWon();

    }

    @Test
    public void startANewGameThenMovingFullMapHasNoWinner()
    {
        applicationRunner.startApplication();
        applicationRunner.startAGame();

        applicationRunner.move(0);
        applicationRunner.move(1);
        applicationRunner.move(2);
        applicationRunner.move(4);
        applicationRunner.move(3);
        applicationRunner.move(5);
        applicationRunner.move(7);
        applicationRunner.move(6);
        applicationRunner.move(8);

        applicationRunner.showsNoWinner();
    }

    @Test
    public void showHistoryWhenNoGameHappen()
    {
        applicationRunner.startApplication();
        applicationRunner.startHistory();
        applicationRunner.showsEmptyHistory();
    }

    @Test
    public void showHistoryWhenOneGameHappenAndClickStop()
    {
        applicationRunner.startApplication();
        applicationRunner.startAGame();
        applicationRunner.move(1);
        applicationRunner.move(2);
        applicationRunner.move(3);
        applicationRunner.endGame();

        applicationRunner.startHistory();
        applicationRunner.showsEmptyHistory();
    }

    @Test
    public void showHistoryWhenOneGameHappenAndAPlayerWinner()
    {
        startANewGameThenMoveThenHasAWinner();
        applicationRunner.startHistory();
        applicationRunner.showsHistoryWhenAGameHappen("1", "X", "X", "1-4-2-5-3");
    }

    @After
    public void close()
    {
        applicationRunner.close();
    }
}
