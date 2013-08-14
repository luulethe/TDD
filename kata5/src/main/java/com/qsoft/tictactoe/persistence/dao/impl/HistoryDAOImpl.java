package com.qsoft.tictactoe.persistence.dao.impl;

import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 11:11 AM
 */
@Component
@Transactional
public class HistoryDAOImpl implements HistoryDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<History> getAllHistories()
    {
        Query query = entityManager.createQuery("select o from History o", History.class);
        return query.getResultList();
    }
}
