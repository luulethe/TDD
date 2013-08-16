package endtoend;

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
}
