package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.List;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 9:49 PM
 */
public interface TransactionDAO
{
    void save(TransactionEntity transactionEntity);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n);
}
