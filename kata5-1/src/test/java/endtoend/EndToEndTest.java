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
    @After
    public void close()
    {
        applicationRunner.close();
    }
}
