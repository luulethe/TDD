package entity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionEntity {
    private String accountNumber;
    private double amount;
    private String description;
    private long timestamp;

    public TransactionEntity(String accountNumber, double amount, String description) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.description = description;
        this.timestamp = System.currentTimeMillis();
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
}
