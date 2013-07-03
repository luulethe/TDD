package com.qsoft.bankaccount.persistence.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Calendar;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 1:41 PM
 */
@Entity
@Table(name = "bank_account")
@SequenceGenerator(name = "seq_id1", sequenceName = "seq_id1", initialValue = 1, allocationSize = 1)
public class BankAccountEntity
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id1")
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "open_time_stamp")
    long openTimeStamp;

    public BankAccountEntity(String accountNumber, double balance, long openTimeStamp)
    {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openTimeStamp = openTimeStamp;
    }

    private static Calendar calendar = Calendar.getInstance();

}
