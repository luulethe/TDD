package entity;

import sun.security.krb5.internal.crypto.CksumType;
import sun.util.resources.CalendarData_ar;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/11/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionEntity {
    String accountNumber;
    double amount;
    String description;
    long timeStamp;
    static Calendar calendar = Calendar.getInstance();

    public TransactionEntity(String accountNumber, double amount, String description) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
        timeStamp = calendar.getTimeInMillis();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Calendar getC() {
        return calendar;
    }

    public static void setCalendar(Calendar c) {
        TransactionEntity.calendar = c;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TransactionEntity) {
            TransactionEntity trE = (TransactionEntity) o;
            return trE.accountNumber.equals(accountNumber) && (trE.amount == amount) && (trE.description.equals(description)) && (trE.timeStamp == timeStamp);
        }
        return false;
    }
}
