package endtoend;

import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JButtonDriver;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JLabelDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.qsoft.tictactoe.ui.view.MainWindow;

import javax.swing.*;

import static org.hamcrest.Matchers.equalTo;

/**
 * User: luult
 * Date: 8/16/13
 * Time: 8:24 AM
 */
public class TicTacToeDriver extends JFrameDriver
{
    public TicTacToeDriver(int timeoutMillis)
    {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(MainWindow.MAIN_WINDOW_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutMillis, 3000));
    }

    private JButtonDriver getButton(String name)
    {
        return new JButtonDriver(this, JButton.class, named(name));
    }

    public void clickStartButton()
    {
        getButton(MainWindow.START_BUTTON_NAME).click();
    }

    public void clickStopButton()
    {
        getButton(MainWindow.STOP_BUTTON_NAME).click();
    }

    public void hasStatusStartGame()
    {
        JLabelDriver labelStatus = new JLabelDriver(this, named(MainWindow.LABEL_STATUS_NAME));
        labelStatus.hasText(equalTo("Started"));        //To change body of created methods use File | Settings | File Templates.
    }

    public void hasStatusEndGame()
    {
        JLabelDriver labelStatus = new JLabelDriver(this, named(MainWindow.LABEL_STATUS_NAME));
        labelStatus.hasText(equalTo("Ended"));        //To change body of created methods use File | Settings | File Templates.
    }

    public void clickCell(int index)
    {
        String name = "button" + index;
        getButton(name).click();
    }

    public void hasLabelInButton(int index, String namePlayer)
    {
        String name = "button" + index;
        getButton(name).hasText(equalTo(namePlayer));
    }

    public void hasStatusXWin()
    {
        JLabelDriver labelStatus = new JLabelDriver(this, named(MainWindow.LABEL_STATUS_NAME));
        labelStatus.hasText(equalTo("X won"));        //T //To change body of created methods use File | Settings | File Templates.
    }

    public void hasStatusNoWinner()
    {
        JLabelDriver labelStatus = new JLabelDriver(this, named(MainWindow.LABEL_STATUS_NAME));
        labelStatus.hasText(equalTo("Draw"));
    }

    public void clickHistoryButton()
    {
        getButton(MainWindow.SHOW_HISTORY_BUTTON_NAME).click();
    }
}
