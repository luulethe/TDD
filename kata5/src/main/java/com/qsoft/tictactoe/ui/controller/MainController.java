package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.persistence.entity.History;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: luult
 * Date: 8/14/13
 * Time: 8:40 AM
 */
@Component
public class MainController
{
    @Autowired
    private MainWindow mainWindow;

    private  History history;

    @Autowired
    MainPanelController mainPanelController;
    String firstPlayer;
    public History getHistory()
    {
        return history;
    }

    @Autowired
    private ButtonPanelController buttonPanelController;

    public void showMainView()
    {
        mainWindow.setContentPanel();
        mainWindow.addActionListener(buttonPanelController);

    }
    public void setFirstPlayer(String firstPlayer)
    {
        this.firstPlayer = firstPlayer;
        if (firstPlayer.equals("X"))
            mainPanelController.setCrossFirst(true);
        else
            mainPanelController.setCrossFirst(false);
    }
    public void createNewHistory()
    {
        history = new History();
        history.setFirstPlayer(firstPlayer);
    }
}
