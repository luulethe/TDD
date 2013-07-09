package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.exception.InvalidLengthNameException;
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
    public void save(BankAccountEntity bankAccountEntity) throws Exception
    {
        if (bankAccountEntity.getAccountNumber().length() != 10)
            throw new InvalidLengthNameException();
        if (bankAccountEntity.getId() == null)
        {
            entityManager.persist(bankAccountEntity);
        }
        else
            entityManager.merge(bankAccountEntity);
        entityManager.flush();
    }
}
