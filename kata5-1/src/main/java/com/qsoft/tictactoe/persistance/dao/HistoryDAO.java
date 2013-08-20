package com.qsoft.tictactoe.persistance.dao;

import com.qsoft.tictactoe.persistance.entity.History;

import java.util.List;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:13 AM
 */
public interface HistoryDAO
{
    List<History> getAllHistories();
}
