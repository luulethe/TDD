package com.qsoft.bankaccount.business.impl;

import com.qsoft.bankaccount.business.TransactionService;
import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 9:31 PM
 */
//@Componentt
public class TransactionServiceImpl implements TransactionService
{
    @Autowired
    private static TransactionDAO transactionDAO;

    public void setDao(TransactionDAO dao)
    {
        this.transactionDAO = dao;
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber)
    {
        return transactionDAO.getTransactionsOccurred(accountNumber);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime)
    {
        return transactionDAO.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n)
    {
        TransactionService transactionService = new TransactionServiceImpl();
        return transactionDAO.getTransactionsOccurred(accountNumber, n);
    }

    @Override
    public void createTransaction(String accountNumber, int amount, String description)
    {
        TransactionEntity transactionEntity = new TransactionEntity(accountNumber, amount, description);
        transactionDAO.save(transactionEntity);//To change body of implemented methods use File | Settings | File Templates.
    }
}
