package entity;

import java.util.Calendar;

import static java.lang.Math.abs;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/13/13
 * Time: 1:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionEntity {
    String accountNumber;
    long timeStamp;
    double amount;
    String description;
    static Calendar calendar = Calendar.getInstance();

    public TransactionEntity(String accountNumber, double amount, String description) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
        this.timeStamp = calendar.getTimeInMillis();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
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

    public static void setCalendar(Calendar calendar) {
        TransactionEntity.calendar = calendar;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TransactionEntity) {
            TransactionEntity trE = (TransactionEntity) o;
            return (accountNumber.equals(trE.accountNumber) && (timeStamp == trE.timeStamp) && (abs(amount - trE.amount) < 0.0001) && (description.equals(trE.description)));
        }
        return false;
    }
}
