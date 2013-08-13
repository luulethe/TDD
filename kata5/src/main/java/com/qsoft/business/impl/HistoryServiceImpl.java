package com.qsoft.business.impl;

import com.qsoft.business.HistoryService;
import com.qsoft.persistence.dao.HistoryDAO;
import com.qsoft.persistence.entity.History;

import java.util.List;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 10:52 AM
 */
public class HistoryServiceImpl implements HistoryService
{
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
}
