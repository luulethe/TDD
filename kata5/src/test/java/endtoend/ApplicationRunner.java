package endtoend;

import com.qsoft.Main;


/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:31 AM
 */
public class ApplicationRunner
{
    private TicTacToeDriver driver;
    public void startGame()
    {
        Thread thread = new Thread("Test Application") {
            @Override public void run() {
                try {
                    Main.main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        thread.setDaemon(true);
        thread.start();

    }

    public void endGame()
    {

    }

}
