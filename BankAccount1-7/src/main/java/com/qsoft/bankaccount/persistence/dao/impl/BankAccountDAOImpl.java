package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 1:38 PM
 */
@Transactional
public class BankAccountDAOImpl implements BankAccountDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BankAccountEntity getAccount(String accountNumber)
    {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void add()
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity("0123456789", 1000, 1000l);
        entityManager.persist(bankAccountEntity);
    }

    @Override
    public void save(BankAccountEntity bankAccountEntity)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
