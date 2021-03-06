package com.qsoft.tictactoe.business;

import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;

import java.util.List;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:08 AM
 */
public interface HistoryService
{
    List<History> getAllHistories();

    void setDao(HistoryDAO mockHistoryDao);

    void save(History history);
}
