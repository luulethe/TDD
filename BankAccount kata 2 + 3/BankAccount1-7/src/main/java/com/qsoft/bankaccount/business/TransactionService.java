package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;

import java.util.List;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 9:31 PM
 */
public interface TransactionService
{
    List<TransactionEntity> getTransactionsOccurred(String accountNumber);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime);

    List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n);

    void createTransaction(String accountNumber, int amount, String description);

    void setDao(TransactionDAO mockTransactionDao);
}
