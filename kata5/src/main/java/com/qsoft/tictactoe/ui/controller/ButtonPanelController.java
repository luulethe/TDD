package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.persistence.entity.History;
import com.qsoft.tictactoe.ui.view.FrameHistory;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * User: luult
 * Date: 8/8/13
 * Time: 9:14 AM
 */
@Component
public class ButtonPanelController implements ActionListener
{
    @Autowired
    private MainWindow mainWindow;
    @Autowired
    private FrameHistory frameHistory;

    @Autowired
    private MainController mainController;

    @Autowired
    private  HistoryService historyService;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            mainWindow.getLbStatus().setText("Started");
            mainWindow.resetMainPanel();
            mainWindow.getBtStart().setEnabled(false);
            mainWindow.getBtStop().setEnabled(true);
            mainController.createNewHistory();
        }
        else if (e.getActionCommand().equals("Stop"))
        {
            mainWindow.getLbStatus().setText("Ended");
            stopGame();
        }
        else if (e.getActionCommand().equals("History"))
        {
            frameHistory.setContentPanel();
            DefaultTableModel tableModel = new DefaultTableModel();
            createTable(tableModel);
            addDataToTable(tableModel);
        }
    }

    public void stopGame()
    {
        mainWindow.disableAllButtonGame();
        mainWindow.getBtStart().setEnabled(true);
        mainWindow.getBtStop().setEnabled(false);
    }

    private void addDataToTable(DefaultTableModel tableModel)
    {
        List<History> historyList = historyService.getAllHistories();
        int i = 1;
        for (History history : historyList)
        {
            tableModel.addRow(new Object[]{i, history.getFirstPlayer(), history.getWinner(), history.getSteps()});
            i++;
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
