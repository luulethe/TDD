package com.qsoft.tictactoe.business.impl;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 10:52 AM
 */
@Component
@Transactional
public class HistoryServiceImpl implements HistoryService
{
    @Autowired
    private HistoryDAO historyDAO;
    @Override
    public List<History> getAllHistories()
    {
        return historyDAO.getAllHistories();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setDao(HistoryDAO mockHistoryDAO)
    {
        this.historyDAO = mockHistoryDAO;
    }

    @Override
    public void save(History history)
    {
        historyDAO.save(history);
    }
}
