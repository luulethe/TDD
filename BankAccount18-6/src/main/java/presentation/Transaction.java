package presentation;

import dao.TransactionDao;
import entity.TransactionEntity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/19/13
 * Time: 2:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDao transactionDao;

    public static void setDao(TransactionDao dao) {
        Transaction.transactionDao = dao;
    }

    public static void createTransaction(String accountNumber, int amount, String description) {
        TransactionEntity transactionEntity = new TransactionEntity(accountNumber, amount, description);
        transactionDao.save(transactionEntity);
    }
}
