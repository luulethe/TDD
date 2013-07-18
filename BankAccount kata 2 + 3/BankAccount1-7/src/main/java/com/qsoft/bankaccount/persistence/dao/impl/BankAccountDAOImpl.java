package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.exception.NegativeBalanceException;
import com.qsoft.bankaccount.exception.NegativeOpenTimeStampException;
import com.qsoft.bankaccount.exception.WrongNameException;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 1:38 PM
 */
@Transactional
@Component
public class BankAccountDAOImpl implements BankAccountDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public BankAccountEntity getAccount(String accountNumber)
    {
        Query query = entityManager.createQuery("select o from BankAccountEntity o where o.accountNumber = :qAccountNumber", BankAccountEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        List<BankAccountEntity> list = query.getResultList();
        if (list.size() == 0)
        {
            return null;
        }
        else
        {
            return list.get(0);
        }
    }

    @Override
    public void add()
    {
        for (int i = 0; i < 10; i++)
        {
            BankAccountEntity bankAccountEntity = new BankAccountEntity("0123456789", 100011, 1000l);
            TransactionEntity transactionEntity = new TransactionEntity("01234333", 1000, "abc");
            entityManager.persist(bankAccountEntity);
            entityManager.persist(transactionEntity);
        }
    }

    @Override
    public void save(BankAccountEntity bankAccountEntity) throws Exception
    {
        validateAccount(bankAccountEntity);
        entityManager.persist(bankAccountEntity);
        entityManager.flush();
    }

    private void validateAccount(BankAccountEntity bankAccountEntity) throws Exception
    {
        if (!isValidateName(bankAccountEntity.getAccountNumber()))
        {
            throw new WrongNameException();
        }
        if (bankAccountEntity.getBalance() < 0)
        {
            throw new NegativeBalanceException();
        }
        if (bankAccountEntity.getOpenTimeStamp() < 0)
        {
            throw new NegativeOpenTimeStampException();
        }
    }

    private boolean isValidateName(String accountNumber)
    {
        if (accountNumber.length() != 10)
        {
            return false;
        }
        for (int i = 0; i < 10; i++)
        {
            if (!((accountNumber.charAt(i) >= '0') && (accountNumber.charAt(i) <= '9')))
            {
                return false;
            }
        }
        return true;
    }
}
