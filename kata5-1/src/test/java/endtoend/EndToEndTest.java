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
        applicationRunner.showsCellIs(1, ROUND_PLAYER);
        applicationRunner.move(3);
        applicationRunner.showsCellIs(1, CROSS_PLAYER);
        applicationRunner.move(4);
        applicationRunner.showsCellIs(1, ROUND_PLAYER);

        applicationRunner.endGame();
        applicationRunner.showsStatusEndGame();
    }

    @After
    public void close()
    {
        applicationRunner.close();
    }
}
