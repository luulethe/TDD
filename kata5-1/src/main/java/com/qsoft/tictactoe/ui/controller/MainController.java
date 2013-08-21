package com.qsoft.tictactoe.ui.controller;

import com.qsoft.tictactoe.persistence.entity.History;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: luult
 * Date: 8/16/13
 * Time: 8:49 AM
 */
@Component
public class MainController
{
    @Autowired
    MainWindow mainWindow;
    private History history;

    public History getHistory()
    {
        return history;
    }

    public void showMainView()
    {
        mainWindow.setContentPanel();
        mainWindow.addListener();
    }

    public void addNextStep(String name)
    {
        history.addNextStep(name);
    }

    public void newHistoryGame()
    {
        history = new History();
        history.setFirstPlayer("X");
    }
}
