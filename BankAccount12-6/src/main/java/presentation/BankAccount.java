package presentation;

import dao.BankAccountDao;
import entity.BankAccountEntity;
import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/12/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    static BankAccountDao bankAccountDao;

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDao.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDao.getAccount(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }

    public static void deposit(String accountNumber, int amount, String description) throws Exception {
        BankAccount.doTransaction(accountNumber, amount, description);
    }


    public static void withdraw(String accountNumber, int amount, String description) throws Exception {
        BankAccount.doTransaction(accountNumber, -amount, description);
    }

    private static void doTransaction(String accountNumber, int amount, String description) throws Exception {
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        if (bankAccountEntity == null)
            throw new Exception("Do not exit any account which account number is " + accountNumber);
        if (bankAccountEntity.getBalance() + amount < 0)
            throw new Exception("Do not enough money");
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        bankAccountDao.save(bankAccountEntity);
        if (amount < 0)
            Transaction.createTransaction(accountNumber, -amount, description);
        else
            Transaction.createTransaction(accountNumber, amount, description);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return Transaction.getTransactionOccurred(accountNumber);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return Transaction.getTransactionOccurred(accountNumber, startTime, stopTime);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) {
        return Transaction.getTransactionOccurred(accountNumber, n);
    }
}
