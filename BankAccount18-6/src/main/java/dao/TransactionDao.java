package dao;

import entity.TransactionEntity;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/19/13
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDao {
    public TransactionDao(DataSource dataSource) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void save(TransactionEntity transactionEntity) {
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
