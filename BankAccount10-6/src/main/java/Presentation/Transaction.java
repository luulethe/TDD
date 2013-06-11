package presentation;

import dao.TransactionDAO;
import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/11/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    static TransactionDAO transactionDao;

    public static void setDao(TransactionDAO transactionDao) {
        Transaction.transactionDao = transactionDao;
    }

    public static TransactionDAO getTransactionDao() {
        return transactionDao;
    }

    public static void createTransaction(String accountNumber, int amount, String description) {
        TransactionEntity transactionEntity = new TransactionEntity(accountNumber, amount, description);
        transactionDao.save(transactionEntity);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return transactionDao.getTransactionsOccurred(accountNumber);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return transactionDao.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    public static List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) {
        return transactionDao.getTransactionsOccurred(accountNumber, n);
    }
}
