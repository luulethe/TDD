package com.qsoft.tictactoe.business.impl;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:08 AM
 */
@Component
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
        historyDAO.save(history);//To change body of implemented methods use File | Settings | File Templates.
    }
}
