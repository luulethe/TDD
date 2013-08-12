package com.qsoft.controller;

import com.qsoft.ui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: luult
 * Date: 8/12/13
 * Time: 3:17 PM
 */
public class MainPanelController  implements ActionListener
{
    Boolean flag = true;
    private MainWindow mainWindow;

    public MainPanelController(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
          String name = e.getActionCommand();
          JButton jButton =  mainWindow.getButton(name);
          if (flag)
              jButton.setText("X");
          else
              jButton.setText("O");
          flag = ! flag;
          jButton.setEnabled(false);
    }
}
