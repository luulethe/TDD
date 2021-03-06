package endtoend;

import com.objogate.wl.Query;
import com.objogate.wl.swing.AWTEventQueueProber;
import com.objogate.wl.swing.driver.JFrameDriver;
import com.objogate.wl.swing.driver.JTableDriver;
import com.objogate.wl.swing.driver.JTableHeaderDriver;
import com.objogate.wl.swing.gesture.GesturePerformer;
import com.qsoft.tictactoe.ui.view.FrameHistory;
import org.hamcrest.Description;
import org.hamcrest.Matchers;

import javax.swing.*;
import javax.swing.table.JTableHeader;

import static com.objogate.wl.swing.matcher.IterableComponentsMatcher.matching;
import static com.objogate.wl.swing.matcher.JLabelTextMatcher.withLabelText;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 9:06 AM
 */
public class HistoryDriver extends JFrameDriver
{
    public HistoryDriver(int timeoutMillis)
    {
        super(new GesturePerformer(),
                JFrameDriver.topLevelFrame(
                        named(FrameHistory.FRAME_HISTORY_NAME),
                        showingOnScreen()),
                new AWTEventQueueProber(timeoutMillis, 4000));
    }

    public void hasColumnTitle()
    {
        JTableHeaderDriver headers = new JTableHeaderDriver(this,
                JTableHeader.class);
        headers.hasHeaders(
                matching(withLabelText("Index"), withLabelText("First player"),
                        withLabelText("Winner"), withLabelText("Steps")));

    }

    public void hasShowEmptyHistory()
    {
        JTableDriver table = new JTableDriver(this);

        checkNumberRow(table, 0);
    }

    private void checkNumberRow(JTableDriver table, int numberRow)
    {
        table.has((new Query<JTable, Integer>()
        {
            public Integer query(JTable component)
            {
                return component.getRowCount();
            }

            public void describeTo(Description description)
            {
                description.appendText("row count");
            }
        }), Matchers.equalTo(numberRow));
    }

    public void hasShowHistoryAGameHappen(String index,String firstPlayer,String winner, String steps)
    {
        JTableDriver table = new JTableDriver(this);
        checkNumberRow(table, 1);
        table.hasRow(
                matching(withLabelText(index), withLabelText(firstPlayer),
                        withLabelText(winner), withLabelText(steps)));
    }
}
