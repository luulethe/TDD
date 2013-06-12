package entity;

import java.util.Calendar;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/12/13
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountEntity {
    String accountNumber;
    double balance;
    long openTimeStamp;
    static  Calendar calendar = Calendar.getInstance();

    public BankAccountEntity(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        openTimeStamp = calendar.getTimeInMillis();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
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

    public static void setCalendar(Calendar calendar) {
        BankAccountEntity.calendar = calendar;
    }

    public double getBalance() {
        return balance;
    }
}
