package com.qsoft.persistence.entity;

import java.security.PrivateKey;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 10:53 AM
 */
public class History
{
    private Long id;
    private String firstPlayer;
    private String winner;
    private String steps;

    public History(String firstPlayer, String winner, String steps)
    {
        this.firstPlayer = firstPlayer;
        this.winner = winner;
        this.steps = steps;
    }

    public String getFirstPlayer()
    {
        return firstPlayer;
    }

    public void setFirstPlayer(String firstPlayer)
    {
        this.firstPlayer = firstPlayer;
    }

    public String getWinner()
    {
        return winner;
    }

    public void setWinner(String winner)
    {
        this.winner = winner;
    }

    public String getSteps()
    {
        return steps;
    }

    public void setSteps(String steps)
    {
        this.steps = steps;
    }
}
