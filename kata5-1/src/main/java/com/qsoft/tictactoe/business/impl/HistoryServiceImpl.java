package com.qsoft.tictactoe.business.impl;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.persistance.dao.HistoryDAO;
import com.qsoft.tictactoe.persistance.entity.History;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:08 AM
 */
public class HistoryServiceImpl implements HistoryService
{
    @Autowired
    private HistoryDAO historyDAO;

    @Override
    public List<History> getAllHistories()
    {
        return historyDAO.getAllHistories();
    }

    @Override
    public void setDao(HistoryDAO mockHistoryDao)
    {
        this.historyDAO = mockHistoryDao;
    }

    @Override
    public void save(History history)
    {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
