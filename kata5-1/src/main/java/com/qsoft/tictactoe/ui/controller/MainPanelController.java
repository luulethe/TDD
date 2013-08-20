package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.ui.utils.WinnerAlgorithm;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: luult
 * Date: 8/19/13
 * Time: 8:38 AM
 */
@Component
public class MainPanelController   implements ActionListener
{
    @Autowired
    private MainWindow mainWindow;
    boolean isCrossFirst = true;
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = e.getActionCommand();
        JButton jButton = mainWindow.getButton(name);
        if (isCrossFirst)
            jButton.setText("X");
        else
            jButton.setText("O");
        isCrossFirst = !isCrossFirst;
        jButton.setEnabled(false);
        String nameWinner = checkWon();
        if (!nameWinner.equals(""))
            mainWindow.getLbStatus().setText(nameWinner + " won");
    }

    private String checkWon()
    {
        String arrayText[] = new String[9];
        for(int i = 0;i < 9; i ++)
            arrayText[i] = mainWindow.getButton(i+"").getText();
        return WinnerAlgorithm.check(arrayText);  //To change body of created methods use File | Settings | File Templates.
    }
}
