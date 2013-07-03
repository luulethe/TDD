package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import java.util.List;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 2:19 PM
 */
public interface BankAccountService
{
    public void setDao(BankAccountDAO bankAccountDAO);

    public BankAccountEntity open(String accountNumber) throws Exception;

    public BankAccountEntity getAccount(String accountNumber) throws Exception;

    public void deposit(String accountNumber, int amount, String description) throws Exception;

    public void withdraw(String accountNumber, int amount, String description) throws Exception;

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) throws Exception;

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) throws Exception;

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) throws Exception;
}
