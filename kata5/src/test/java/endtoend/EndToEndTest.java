package endtoend;

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
        application.endGame();
    }
}
