package endtoend;

import com.objogate.wl.Prober;
import com.objogate.wl.swing.ComponentSelector;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;

import javax.swing.*;

/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:54 AM
 */
public class TicTacToeDriver extends JFrameDriver
{
    public TicTacToeDriver(GesturePerformer gesturePerformer, ComponentSelector<JFrame> componentSelector, Prober prober)
    {
        super(gesturePerformer, componentSelector, prober);
    }
}
