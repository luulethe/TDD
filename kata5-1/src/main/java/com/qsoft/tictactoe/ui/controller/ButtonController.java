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
import java.util.List;

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

    @Autowired
    HistoryService historyService;

    @Autowired
    MainController mainController;
    @Autowired
    MainPanelController mainPanelController;

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            mainWindow.getLbStatus().setText("Started");
            setStartGame();
        }
        else if (e.getActionCommand().equals("Stop"))
        {
            mainWindow.getLbStatus().setText("Ended");
            setStopGame();
        }
        else if (e.getActionCommand().equals("History"))
        {
            frameHistory.setContenpanel();
            DefaultTableModel tableModel = new DefaultTableModel();
            createTable(tableModel);
            setTableModel(tableModel);
        }
    }

    public void setStopGame()
    {
        mainWindow.getBtStart().setEnabled(true);
        mainWindow.getBtStop().setEnabled(false);
        for (int i = 0; i < 9; i++)
        {
            mainWindow.getButton(i + "").setEnabled(false);
        }
    }

    public void setStartGame()
    {
        mainWindow.getBtStart().setEnabled(false);
        mainWindow.getBtStop().setEnabled(true);
        mainWindow.getMainPanel().setVisible(true);
        for (int i = 0; i < 9; i++)
        {
            mainWindow.getButton(i + "").setEnabled(true);
            mainWindow.getButton(i + "").setText("");
        }
        mainController.newHistoryGame();
        mainPanelController.setCrossFirst(true);
    }

    private void setTableModel(DefaultTableModel tableModel)
    {
        List<History> historyList = historyService.getAllHistories();
        int i = 1;
        for (History history : historyList)
        {
            tableModel.addRow(new Object[]{i, history.getFirstPlayer(), history.getWinner(), history.getSteps()});
            i++;
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
