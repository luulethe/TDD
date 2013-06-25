package dao;

import entity.BankAccountEntity;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/18/13
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccountDao {
    private Connection dbConnection;

    public BankAccountDao(DataSource dataSource) throws SQLException {
        this.dbConnection = dataSource.getConnection();
    }

    public void save(BankAccountEntity bankAccountEntity) throws SQLException {
        String accountNumber = bankAccountEntity.getAccountNumber();
        String queryString = "SELECT * FROM SAVINGS_ACCOUNT WHERE ACCOUNT_NUMBER='" + accountNumber+ "'";
        ResultSet resultSet = dbConnection.createStatement().executeQuery(queryString);
        if (resultSet.next()) {
            String queryStringSave = "UPDATE SAVINGS_ACCOUNT SET balance = " + bankAccountEntity.getBalance() + " WHERE account_number = '" + accountNumber + "'" ;
            System.out.println(queryStringSave);
            dbConnection.createStatement().executeUpdate(queryStringSave);
        }
    }
    public BankAccountEntity getAccount(String accountNumber) throws SQLException {
        String queryString = "SELECT * FROM SAVINGS_ACCOUNT WHERE ACCOUNT_NUMBER='" + accountNumber + "'";
        ResultSet resultSet = dbConnection.createStatement().executeQuery(queryString);
        if (resultSet.next())
            return new BankAccountEntity(accountNumber, resultSet.getDouble("balance"), resultSet.getLong("open_time_stamp"));
        else
            return null;
    }
}
