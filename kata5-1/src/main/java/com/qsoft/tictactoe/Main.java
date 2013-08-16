package com.qsoft.tictactoe;

import com.qsoft.tictactoe.ui.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: luult
 * Date: 8/16/13
 * Time: 8:11 AM
 */
public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MainController mainController = applicationContext.getBean(MainController.class);
        mainController.showMainView();
    }
}
