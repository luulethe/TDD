package presentation;

import dao.BankAccountDAO;
import entity.BankAccountEntity;
import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/10/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO;

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        BankAccount.bankAccountDAO = bankAccountDAO;
    }

    public static BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDAO.getAccount(accountNumber);
    }

    public static void deposit(String accountNumber, int amount, String description) throws Exception {
        doTransaction(accountNumber, amount, description);
    }

    public static void withdraw(String accountNumber, int amount, String description) throws Exception {
        doTransaction(accountNumber, -amount, description);
    }

    private static void doTransaction(String accountNumber, int amount, String description) throws Exception {
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        if (bankAccountEntity.getBalance() + amount < 0)
            throw new Exception("don't enough money");
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        if (amount < 0)
            amount = -amount;
        Transaction.createTransaction(accountNumber, amount, description);
        bankAccountDAO.save(bankAccountEntity);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return Transaction.getTransactionsOccurred(accountNumber);
        //To change body of created methods use File | Settings | File Templates.
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return Transaction.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) {
        return Transaction.getTransactionsOccurred(accountNumber, n);
    }
}
