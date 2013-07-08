package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: luult
 * Date: 7/5/13
 * Time: 7:33 AM
 */
public class TestSample
{
    @Test
    public void testSample() {
        ApplicationContext appContext = new ClassPathXmlApplicationContext(
                "testContext.xml");
        BankAccountDAO bankAccountDAO = (BankAccountDAO) appContext.getBean("bankAccountDAO");
        bankAccountDAO.add();
        //BankAccountDAO bankAccountDAO = new BankAccountDAOImpl();
//        BankAccountEntity account = bankAccountDAO.getAccount("0");
//        System.out.println(account);
//        System.out.println(account.getAccountNumber());
//        System.out.println(account.getBalance());
    }

}
