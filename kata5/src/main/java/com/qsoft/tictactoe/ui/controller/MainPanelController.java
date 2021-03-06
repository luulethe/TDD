package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * User: luult
 * Date: 8/12/13
 * Time: 3:17 PM
 */
@Component
public class MainPanelController implements ActionListener
{
    Boolean isCrossFirst;
    @Autowired
    private MainWindow mainWindow;

    @Autowired
    private MainController mainController;

    @Autowired
    private  ButtonPanelController buttonPanelController;

    @Autowired
    private HistoryService historyService;

    public void setCrossFirst(Boolean crossFirst)
    {
        isCrossFirst = crossFirst;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String name = e.getActionCommand();
        JButton jButton = mainWindow.getButton(name);
        if (isCrossFirst)
        {
            jButton.setText("X");
        }
        else
        {
            jButton.setText("O");
        }
        mainController.getHistory().addNextStep(name);
        isCrossFirst = !isCrossFirst;
        jButton.setEnabled(false);
        String nameOfWinner = checkWinner();
        if (!nameOfWinner.equals(""))
        {
            mainWindow.getLbStatus().setText(nameOfWinner + " won");
            mainController.getHistory().setWinner(nameOfWinner);
            buttonPanelController.stopGame();
            historyService.save(mainController.getHistory());
        }
        else if (checkFull())
        {
            mainWindow.getLbStatus().setText("Draw");
            buttonPanelController.stopGame();
            historyService.save(mainController.getHistory());
        }
    }

    private boolean checkFull()
    {
        for (int i = 0; i < 9; i++)
        {
            if (mainWindow.getButton(i + "").getText().toString().equals(""))
            {
                return false;
            }
        }
        return true;
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
        if (arrayText[0].equals(arrayText[4]) && arrayText[4].equals(arrayText[8]))
        {
            return arrayText[0];
        }
        if (arrayText[2].equals(arrayText[4]) && arrayText[4].equals(arrayText[6]))
        {
            return arrayText[2];
        }
        return "";
    }
}
