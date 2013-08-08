package endtoend;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.qsoft.ui.MainWindow;

import javax.swing.*;

import static org.hamcrest.Matchers.equalTo;

/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:54 AM
 */
public class TicTacToeDriver extends JFrameDriver
{
    public TicTacToeDriver(int timeoutMillis)
    {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(MainWindow.MAIN_WINDOW_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutMillis, 100));
    }
    private JButtonDriver startButton() {
        return new JButtonDriver(this, JButton.class, named(MainWindow.START_BUTTON_NAME));
    }

    private JButtonDriver endButton() {
        return new JButtonDriver(this, JButton.class, named(MainWindow.END_BUTTON_NAME));
    }
    public void hasStatusStartGame()
    {
        JLabelDriver labelStatus = new JLabelDriver(this, named(MainWindow.LABEL_STATUS_NAME));
        labelStatus.hasText(equalTo("Started"));
    }

    public void clickEndButton()
    {
        endButton().click();
    }

    public void clickStartButton()
    {
        startButton().click();
    }

    public void hasStatusEndGame()
    {
        JLabelDriver labelStatus = new JLabelDriver(this, named(MainWindow.LABEL_STATUS_NAME));
        labelStatus.hasText(equalTo("Ended"));
        //To change body of created methods use File | Settings | File Templates.
    }
}
