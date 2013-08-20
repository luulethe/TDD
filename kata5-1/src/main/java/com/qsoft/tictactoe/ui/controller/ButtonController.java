package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            mainWindow.getLbStatus().setText("Started");
            setGameWhenStart();

        }
        else if (e.getActionCommand().equals("Stop"))
        {
            mainWindow.getLbStatus().setText("Ended");
            setWhenGameStop();
        }
    }

    private void setWhenGameStop()
    {
        mainWindow.getBtStart().setEnabled(true);
        mainWindow.getBtStop().setEnabled(false);
        for(int i = 0 ; i < 9; i++)
        {
            mainWindow.getButton(i+"").setEnabled(false);
        }
    }

    private void setGameWhenStart()
    {
        mainWindow.getBtStart().setEnabled(false);
        mainWindow.getBtStop().setEnabled(true);
        mainWindow.getMainPanel().setVisible(true);
        for(int i = 0 ; i < 9; i++)
        {
            mainWindow.getButton(i+"").setEnabled(true);
            mainWindow.getButton(i+"").setText("");
        }
    }
}
