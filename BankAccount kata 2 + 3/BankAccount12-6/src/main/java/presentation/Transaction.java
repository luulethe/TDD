package presentation;

import dao.TransactionDao;
import entity.BankAccountEntity;
import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/13/13
 * Time: 1:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    static public TransactionDao transactionDao;

    public static void setDao(TransactionDao transactionDao) {
        Transaction.transactionDao = transactionDao;
    }

    public static TransactionDao getTransactionDao() {
        return transactionDao;
    }

    public static void deposit(String accountNumber, int amount, String description) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public static void createTransaction(String accountNumber, int amount, String description) {
        TransactionEntity transactionEntity = new TransactionEntity(accountNumber, amount, description);
        transactionDao.save(transactionEntity);
    }

    public static List<TransactionEntity> getTransactionOccurred(String accountNumber) {
        return transactionDao.TransactionsOccurred(accountNumber);
    }

    public static List<TransactionEntity> getTransactionOccurred(String accountNumber, long startTime, long stopTime) {
        return transactionDao.TransactionsOccurred(accountNumber, startTime, stopTime);
    }

    public static List<TransactionEntity> getTransactionOccurred(String accountNumber, int n) {
        return transactionDao.TransactionsOccurred(accountNumber, n);
    }
}
