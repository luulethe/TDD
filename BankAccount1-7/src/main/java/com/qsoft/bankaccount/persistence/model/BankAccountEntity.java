package com.qsoft.bankaccount.persistence.model;

import javax.persistence.*;
import java.util.Calendar;

/**
 * User: luult
 * Date: 7/2/13
 * Time: 1:41 PM
 */
@Entity
@Table(name = "bank_account")
public class BankAccountEntity
{
    @GeneratedValue
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "balance")
    private double balance;

    @Column(name = "open_time_stamp")
    long openTimeStamp;

    private static Calendar calendar = Calendar.getInstance();

}
