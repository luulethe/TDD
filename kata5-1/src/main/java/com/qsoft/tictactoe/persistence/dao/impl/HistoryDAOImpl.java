package com.qsoft.tictactoe.persistence.dao.impl;

import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:22 AM
 */
@Component
@Transactional
public class HistoryDAOImpl implements HistoryDAO
{
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<History> getAllHistories()
    {
        Query query = entityManager.createQuery("select o from History o", History.class);
        return query.getResultList();
    }

    @Override
    public void save(History history)
    {
        entityManager.persist(history);
    }
}
