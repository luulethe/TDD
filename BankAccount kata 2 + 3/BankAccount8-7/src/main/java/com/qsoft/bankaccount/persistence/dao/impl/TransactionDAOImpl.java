package com.qsoft.bankaccount.persistence.dao.impl;

import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 9:49 PM
 */
@Component
public class TransactionDAOImpl implements TransactionDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(TransactionEntity transactionEntity)
    {
        entityManager.persist(transactionEntity);
        entityManager.flush();
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber)
    {
        Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber", TransactionEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        return query.getResultList();
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime)
    {
        Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber and o.openTimeStamp >= :qStartTime and o.openTimeStamp <= :qStopTime", TransactionEntity.class);
        query.setParameter("qAccountNumber", accountNumber);
        query.setParameter("qStartTime", startTime);
        query.setParameter("qStopTime", stopTime);
        return query.getResultList();
    }

    @Override
    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n)
    {
        if (n == 0)
            return null;
        Query query = entityManager.createQuery("select o from TransactionEntity o where o.accountNumber = :qAccountNumber order by o.openTimeStamp desc ", TransactionEntity.class);
        query.setMaxResults(n);
        query.setParameter("qAccountNumber", accountNumber);
        return query.getResultList();
    }
}
