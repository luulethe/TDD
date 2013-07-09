package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 9:49 PM
 */
public class TransactionDAOImpl implements TransactionDAO
{

    @Override
    public void save(TransactionEntity transactionEntity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
