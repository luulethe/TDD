package entity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountEntity {
    String accountNumber = null;
    double balance = 0;
    long openTimestamp;

    public BankAccountEntity(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.openTimestamp = System.currentTimeMillis();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getOpenTimestamp() {
        return openTimestamp;
    }

    public void setOpenTimestamp(long openTimestamp) {
        this.openTimestamp = openTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof BankAccountEntity) {
            BankAccountEntity otherAccount = (BankAccountEntity) o;
            if (otherAccount.getAccountNumber().equals(accountNumber) && (otherAccount.getBalance() - balance < 0.00001) &&
                    (otherAccount.getOpenTimestamp() == openTimestamp))
                return true;
            else
                return false;
        }
        return false;
    }
}
