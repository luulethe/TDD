package com.qsoft.tictactoe.ui.view;

import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 9:09 AM
 */
@Component
public class FrameHistory extends JFrame
{
    public static final String FRAME_HISTORY_NAME = "History";
    public static final String APPLICATION_TITLE = "History";
    private JPanel panel1;
    private JTable historyTable;

    public void setContenpanel()
    {
        setName(FRAME_HISTORY_NAME);
        setTitle(APPLICATION_TITLE);
        setMinimumSize(new Dimension(500, 500));
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public JTable getHistoryTable()
    {
        return historyTable;
    }
}
