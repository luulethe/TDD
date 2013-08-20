package com.qsoft.tictactoe.persistance.dao.impl;

import com.qsoft.tictactoe.persistance.dao.HistoryDAO;
import com.qsoft.tictactoe.persistance.entity.History;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    @Override
    public List<History> getAllHistories()
    {
        return null;
    }
}
