package entity;

import utils.MyTimer;
import utils.MyTimerClass;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionEntity {
    public static MyTimer mytimer = new MyTimerClass();
    private String accountNumber;
    private double amount;
    private String description;
    private long timestamp;

    //private Timer
    public TransactionEntity(String accountNumber, double amount, String description) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
        this.timestamp = mytimer.getCurrentTime();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public static void setMyTimer(MyTimer myTimer1) {
        TransactionEntity.mytimer = myTimer1;

        //this.mytimer = mytimer;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof TransactionEntity) {
            TransactionEntity otherObject = (TransactionEntity) o;
            return (otherObject.accountNumber.equals(accountNumber)) && (otherObject.getAmount() == amount) && (
                    otherObject.getDescription().equals(description)) && (otherObject.getTimestamp() == timestamp);
        }
        return false;
    }
}
