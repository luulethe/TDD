package entity;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/19/13
 * Time: 2:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionEntity {
    private String accountNumber;
    private String description;
    private double amount;
    private long openTimeStamp;
    private static Calendar calendar = Calendar.getInstance();

    public TransactionEntity(String accountNumber, double amount, String description) {
        this.accountNumber = accountNumber;
        this.description = description;
        this.amount = amount;
        this.openTimeStamp = calendar.getTimeInMillis();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(long openTimeStamp) {
        this.openTimeStamp = openTimeStamp;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public static void  setCalendar(Calendar calendar) {
        TransactionEntity.calendar = calendar;
    }
}
