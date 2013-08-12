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
}
