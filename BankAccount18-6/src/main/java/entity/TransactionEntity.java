package entity;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public long getOpenTimeStamp() {
        return openTimeStamp;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
