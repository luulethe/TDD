package com.qsoft.tictactoe.persistence.entity;

import javax.persistence.*;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:14 AM
 */
@Entity
@Table(name = "history")
@SequenceGenerator(name = "history_id_seq", sequenceName = "history_id_seq", initialValue = 1, allocationSize = 1)
public class History
{

    @GeneratedValue(strategy = GenerationType.AUTO, generator = "history_id_seq")
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "first_player", length = 1)
    private String firstPlayer;
    @Column(name = "winner", length = 1)
    private String winner;
    @Column(name = "steps", length = 30)
    private String steps;

    public History()
    {
    }

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

    public void addNextStep(String name)
    {
        if ((steps == null) || ("".equals(steps)))
        {
            steps = (Integer.parseInt(name) + 1) + "" ;
        }
        else
        {
            steps += "-" + (Integer.parseInt(name) + 1) + "";//To change body of created methods use File | Settings | File Templates.
        }
    }
}
