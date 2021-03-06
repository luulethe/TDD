package com.qsoft.tictactoe.persistence.dao;

import com.qsoft.tictactoe.persistence.entity.History;

import java.util.List;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 11:10 AM
 */
public interface HistoryDAO
{
    List<History> getAllHistories();

    void save(History history);

}
