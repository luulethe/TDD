package entity;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/18/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountEntity {
    private String accountNumber;
    private double balance;
    long openTimeStamp;
    private static Calendar calendar = Calendar.getInstance();

    public BankAccountEntity(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openTimeStamp = calendar.getTimeInMillis();
    }

    public static void setCalendar(Calendar calendar) {
        BankAccountEntity.calendar = calendar;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(Long openTimeStamp) {
        this.openTimeStamp = openTimeStamp;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
