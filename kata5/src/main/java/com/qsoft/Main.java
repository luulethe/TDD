package com.qsoft;

import com.qsoft.tictactoe.ui.controller.MainController;
import com.qsoft.tictactoe.ui.view.MainWindow;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: luult
 * Date: 8/7/13
 * Time: 8:42 AM
 */
public class Main
{

    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MainController mainController = applicationContext.getBean(MainController.class);
        mainController.showMainView();
        mainController.setFirstPlayer("X");
    }

//    public static void main()
//    {
//        new MainWindow();
//        //To change body of created methods use File | Settings | File Templates.
//    }
}
