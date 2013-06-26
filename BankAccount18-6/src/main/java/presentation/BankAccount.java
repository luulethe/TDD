package presentation;

import dao.BankAccountDao;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import exceptionPackage.DoNotExitAccountException;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/18/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static BankAccountEntity open(String accountNumber) throws Exception{
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDao.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountEntity getAccount(String accountNumber) throws Exception{
        return bankAccountDao.getAccount(accountNumber);
    }

    public static void deposit(String accountNumber, int amount, String description) throws Exception {
        doTransaction(accountNumber, amount, description);
    }


    public static void withdraw(String accountNumber, int amount, String description) throws Exception {
        doTransaction(accountNumber, -amount, description);
    }

    private static void doTransaction(String accountNumber, int amount, String description) throws Exception {
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        if (bankAccountEntity == null)
            throw new DoNotExitAccountException("Don't exit account");
        if (bankAccountEntity.getBalance() + amount < 0)
            throw new Exception("Don't enough money");
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        bankAccountDao.save(bankAccountEntity);
        if (amount < 0)
            Transaction.createTransaction(accountNumber, -amount, description);
        else
            Transaction.createTransaction(accountNumber, amount, description);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        System.out.println("dddd");
        return Transaction.getTransactionsOccurred(accountNumber);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return Transaction.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) {
        return Transaction.getTransactionsOccurred(accountNumber, n);
    }

}
