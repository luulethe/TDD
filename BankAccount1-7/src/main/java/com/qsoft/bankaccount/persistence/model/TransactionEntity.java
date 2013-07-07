package com.qsoft.bankaccount.persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 9:18 PM
 */
@Entity
@Table(name = "transaction")
@SequenceGenerator(name = "seq_id", sequenceName = "seq_id", initialValue = 1, allocationSize = 1)

public class TransactionEntity
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "amount")
    private double amount;

    @Column(name = "open_time_stamp")
    private long openTimeStamp;

    private static Calendar calendar = Calendar.getInstance();

    public TransactionEntity()
    {
    }

    public TransactionEntity(String accountNumber, double amount, String description)
    {
        this.accountNumber = accountNumber;
        this.description = description;
        this.amount = amount;
        this.openTimeStamp = calendar.getTimeInMillis();
    }

    public TransactionEntity(String accountNumber, long openTimeStamp, double amount, String description)
    {
        this.accountNumber = accountNumber;
        this.description = description;
        this.amount = amount;
        this.openTimeStamp = openTimeStamp;
    }

    public String getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber)
    {
        this.accountNumber = accountNumber;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public long getOpenTimeStamp()
    {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(long openTimeStamp)
    {
        this.openTimeStamp = openTimeStamp;
    }

    public Calendar getCalendar()
    {
        return calendar;
    }

    public static void setCalendar(Calendar calendar)
    {
        TransactionEntity.calendar = calendar;
    }
}

