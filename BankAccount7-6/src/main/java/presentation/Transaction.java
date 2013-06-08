package presentation;

import dao.TransactionDAO;
import entity.TransactionEntity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {
    private static TransactionDAO dao;

    public static TransactionDAO getDao() {
        return dao;
    }

    public static void setDao(TransactionDAO dao) {
        Transaction.dao = dao;
    }
    public static TransactionEntity createTransaction(String accountNumber, double amount, String description) {
        TransactionEntity transactionEntity =  new TransactionEntity(accountNumber, amount, description);
        dao.save(transactionEntity);
        return transactionEntity;
    }
}
