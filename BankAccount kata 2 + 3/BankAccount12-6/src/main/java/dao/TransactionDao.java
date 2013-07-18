package dao;

import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/13/13
 * Time: 1:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDao {
    public void save(TransactionEntity transactionEntity) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionEntity> TransactionsOccurred(String accountNumber) {
        return null;
    }

    public List<TransactionEntity> TransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionEntity>  TransactionsOccurred(String accountNumber, int n) {
        return  null;
    }
}
