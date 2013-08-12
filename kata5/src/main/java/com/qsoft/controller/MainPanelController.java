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
public class MainPanelController implements ActionListener
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
        JButton jButton = mainWindow.getButton(name);
        if (flag)
        {
            jButton.setText("X");
        }

        else
        {
            jButton.setText("O");
        }
        flag = !flag;
        jButton.setEnabled(false);
        String nameOfWinner = checkWinner();
        if (!nameOfWinner.equals(""))
        {
            mainWindow.getLbStatus().setText(nameOfWinner + " won");
        }
    }

    private String checkWinner()
    {
        String arrayText[] = new String[9];
        for (int i = 0; i < 9; i++)
        {
            arrayText[i] = mainWindow.getButton(i + "").getText().toString();
        }
        for (int i = 0; i < 3; i++)
        {
            if (arrayText[3 * i].equals(arrayText[3 * i + 1]) && arrayText[3 * i + 1].equals(arrayText[3 * i + 2]))
            {
                return arrayText[3 * i];
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if (arrayText[i].equals(arrayText[i + 3]) && arrayText[i + 3].equals(arrayText[i + 6]))
            {
                return arrayText[i];
            }
        }
        return "";
    }
}
