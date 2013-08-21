package com.qsoft.tictactoe.persistence.dao;

import com.qsoft.tictactoe.persistence.entity.History;

import java.util.List;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:13 AM
 */
public interface HistoryDAO
{
    List<History> getAllHistories();

    void save(History history);
}
