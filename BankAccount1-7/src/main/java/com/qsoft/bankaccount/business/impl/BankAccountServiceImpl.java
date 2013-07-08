package com.qsoft.bankaccount.business.impl;

import com.qsoft.bankaccount.business.BankAccountService;
import com.qsoft.bankaccount.business.TransactionService;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 2:19 PM
 */

public class BankAccountServiceImpl implements BankAccountService
{
    @Autowired
    private static BankAccountDAO bankAccountDAO;

    public void setDao(BankAccountDAO bankAccountDAO)
    {
        this.bankAccountDAO = bankAccountDAO;
        System.out.println("daodaodaodao");
        System.out.println(this.bankAccountDAO);
    }

    public BankAccountDAO getDao()
    {
        return bankAccountDAO;
    }

    public BankAccountEntity open(String accountNumber) throws Exception
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }

    @Override
    public BankAccountEntity getAccount(String accountNumber) throws Exception
    {
        System.out.println(bankAccountDAO);
        return bankAccountDAO.getAccount(accountNumber);
    }

    @Override
    public void deposit(String accountNumber, int amount, String description) throws Exception
    {
        doTransaction(accountNumber, amount, description);
    }

    @Override
    public void withdraw(String accountNumber, int amount, String description) throws Exception
    {
        doTransaction(accountNumber, -amount, description);
    }

    private void doTransaction(String accountNumber, int amount, String description) throws Exception
    {
        BankAccountService bankAccountService = new BankAccountServiceImpl();
        BankAccountEntity bankAccountEntity = bankAccountService.getAccount(accountNumber);

        if (bankAccountEntity == null)
        {
            throw new Exception("Don't exit account");
        }
        if (bankAccountEntity.getBalance() + amount < 0)
        {
            throw new Exception("Don't enough money");
        }
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        bankAccountDAO.save(bankAccountEntity);
        TransactionService transactionService = new TransactionServiceImpl();
        if (amount < 0)
        {
            transactionService.createTransaction(accountNumber, -amount, description);
        }
        else
        {
            transactionService.createTransaction(accountNumber, amount, description);
        }
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) throws Exception
    {
        TransactionService transactionService = new TransactionServiceImpl();
        return transactionService.getTransactionsOccurred(accountNumber);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) throws Exception
    {
        TransactionService transactionService = new TransactionServiceImpl();
        return transactionService.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) throws Exception
    {
        TransactionService transactionService = new TransactionServiceImpl();
        return transactionService.getTransactionsOccurred(accountNumber, n);
    }
}
