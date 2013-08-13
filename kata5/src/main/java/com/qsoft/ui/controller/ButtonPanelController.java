package com.qsoft.ui.controller;

import com.qsoft.business.HistoryService;
import com.qsoft.persistence.entity.History;
import com.qsoft.ui.view.FrameHistory;
import com.qsoft.ui.view.MainWindow;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * User: luult
 * Date: 8/8/13
 * Time: 9:14 AM
 */
public class ButtonPanelController implements ActionListener
{
    private MainWindow mainWindow;
    private FrameHistory frameHistory;
    private HistoryService historyService;

    public void setMainWindow(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            mainWindow.getLbStatus().setText("Started");
            mainWindow.resetMainPanel();
            mainWindow.getBtStart().setEnabled(false);
            mainWindow.getBtStop().setEnabled(true);
        }
        else if (e.getActionCommand().equals("Stop"))
        {
            mainWindow.getLbStatus().setText("Ended");
            mainWindow.disableAllButtonGame();
            mainWindow.getBtStart().setEnabled(true);
            mainWindow.getBtStop().setEnabled(false);
        }
        else if (e.getActionCommand().equals("History"))
        {
            frameHistory = new FrameHistory();
            DefaultTableModel tableModel = new DefaultTableModel();
            createTable(tableModel);
            List<History> historyList = historyService.getAllHistories();
        }
    }

    private void createTable(DefaultTableModel tableModel)
    {
        tableModel.addColumn("Index");
        tableModel.addColumn("First player");
        tableModel.addColumn("Winner");
        tableModel.addColumn("Steps");
        frameHistory.getHistoryTable().setModel(tableModel);
        frameHistory.getHistoryTable().setRowHeight(20);
    }
}
