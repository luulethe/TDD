package presentation;

import dao.TransactionDao;

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
}
