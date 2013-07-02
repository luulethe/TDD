package com.qsoft.bankaccount;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: luult
 * Date: 6/28/13
 * Time: 3:04 PM
 */
public class AppMain
{
    public static void main(String[] args)
    {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "applicationContext.xml");
    }
}
