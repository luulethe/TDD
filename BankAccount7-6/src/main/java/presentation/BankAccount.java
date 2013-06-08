package presentation;

import dao.BankAccountDAO;
import dao.TransactionDAO;
import entity.BankAccountEntity;
import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO;

    public BankAccount(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    public static BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public static void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        BankAccount.bankAccountDAO = bankAccountDAO;
    }

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void deposit(String accountNumber, int amount, String description) {
        doTransaction(accountNumber, amount, description);
    }

    private static void doTransaction(String accountNumber, int amount, String description) {
        BankAccountEntity bankAccountEntity = bankAccountDAO.getAccount(accountNumber);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        bankAccountDAO.save(bankAccountEntity);
        Transaction.createTransaction(accountNumber, amount, description);
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDAO.getAccount(accountNumber);
    }

    public static void Withdraw(String accountNumber, int amount, String description) {
        doTransaction(accountNumber, -amount, description);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return Transaction.getTransactionsOccurred(accountNumber);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return Transaction.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, long times) throws Exception {
        if (times < 0) throw new Exception("time have to bigger than 0");
        return Transaction.getTransactionsOccurred(accountNumber, times);
    }
}
