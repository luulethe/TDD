package dao;

import entity.BankAccountEntity;
import entity.TransactionEntity;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDAO {
    public void save(TransactionEntity transactionEntity) {

    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) {
        return null;
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long times) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
