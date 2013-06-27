package dao;

import entity.BankAccountEntity;
import entity.TransactionEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/19/13
 * Time: 2:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class TransactionDao {
    private Connection dbConnection;

    public TransactionDao(DataSource dataSource) throws Exception {
        this.dbConnection = dataSource.getConnection();
    }

    public void save(TransactionEntity transactionEntity) throws  Exception {
        String queryStringSave = "INSERT INTO TRANSACTION(account_number, timestamp, amount, description) VALUES ('"
                + transactionEntity.getAccountNumber() + "'," + transactionEntity.getOpenTimeStamp() + "," + transactionEntity.getAmount()
                + ",'" + transactionEntity.getDescription() + "');";
        System.out.println(queryStringSave);
        dbConnection.createStatement().executeUpdate(queryStringSave);

    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber) throws Exception {
        String queryString = "SELECT * FROM TRANSACTION WHERE ACCOUNT_NUMBER='" + accountNumber + "'";
        ResultSet resultSet = dbConnection.createStatement().executeQuery(queryString);
        if (resultSet.next()) {
            List<TransactionEntity> tempList = new ArrayList<TransactionEntity>();
            do {
                tempList.add(new TransactionEntity(accountNumber, resultSet.getLong("timestamp"), resultSet.getDouble("amount"), resultSet.getString("description")));
            }
            while (resultSet.next());
            return tempList;
        } else
            return null;
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, long startTime, long stopTime) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    public List<TransactionEntity> getTransactionsOccurred(String accountNumber, int n) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
