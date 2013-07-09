package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.model.BankAccountEntity;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 1:36 PM
 */
public interface BankAccountDAO
{
    public BankAccountEntity getAccount(String accountNumber) ;

    void save(BankAccountEntity bankAccountEntity)throws Exception;
}
