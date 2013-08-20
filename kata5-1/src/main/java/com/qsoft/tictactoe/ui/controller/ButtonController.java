package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.ui.view.FrameHistory;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: luult
 * Date: 8/16/13
 * Time: 9:30 AM
 */
@Component
public class ButtonController implements ActionListener
{
    @Autowired
    private MainWindow mainWindow;

    @Autowired
    private FrameHistory frameHistory;


    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            mainWindow.getLbStatus().setText("Started");
            mainWindow.getBtStart().setEnabled(false);
            mainWindow.getBtStop().setEnabled(true);
            mainWindow.getMainPanel().setVisible(true);
        }
        else if (e.getActionCommand().equals("Stop"))
        {
            mainWindow.getLbStatus().setText("Ended");
            mainWindow.getBtStart().setEnabled(true);
            mainWindow.getBtStop().setEnabled(false);
        }
        else if (e.getActionCommand().equals("History"))
        {
            frameHistory.setContenpanel();
            DefaultTableModel tableModel = new DefaultTableModel();
            createTable(tableModel);
        }
    }
    public void createTable(DefaultTableModel tableModel)
    {
        tableModel.addColumn("Index");
        tableModel.addColumn("First player");
        tableModel.addColumn("Winner");
        tableModel.addColumn("Steps");
        frameHistory.getHistoryTable().setModel(tableModel);

    }
}
