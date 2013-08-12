package com.qsoft.controller;

import com.qsoft.ui.MainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: luult
 * Date: 8/8/13
 * Time: 9:14 AM
 */
public class MainWindowController implements ActionListener
{
    private MainWindow mainWindow;

    Boolean flag = true;

    public MainWindowController(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("Start"))
        {
            mainWindow.getLbStatus().setText("Started");
        }
        else if (e.getActionCommand().equals("Stop"))
        {
            mainWindow.getLbStatus().setText("Ended");
        }
        else if (e.getActionCommand().equals("button1"))
        {
            if (flag)
            {
                mainWindow.getButton1().setText("X");
            }
            else
            {
                mainWindow.getButton1().setText("O");
            }
            flag = !flag;
            mainWindow.getButton1().setEnabled(false);
        }
        else if (e.getActionCommand().equals("button2"))
        {
            if (flag)
            {
                mainWindow.getButton2().setText("X");
            }
            else
            {
                mainWindow.getButton2().setText("O");
            }
            flag = !flag;
            mainWindow.getButton2().setEnabled(false);
        }
        else if (e.getActionCommand().equals("button3"))
        {
            if (flag)
            {
                mainWindow.getButton3().setText("X");
            }
            else
            {
                mainWindow.getButton3().setText("O");
            }
            flag = !flag;
            mainWindow.getButton3().setEnabled(false);
        }

    }
}
