package com.qsoft.bankaccount;

import com.qsoft.bankaccount.business.impl.BankAccountServiceImpl;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
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
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
        bankAccountDAO.add();
        //BankAccountServiceImpl
    }
}
