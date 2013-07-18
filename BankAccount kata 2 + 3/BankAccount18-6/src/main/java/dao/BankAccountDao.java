package dao;

import entity.BankAccountEntity;
import exceptionPackage.NegativeBalaceException;
import exceptionPackage.NegativeOpenTimeStampException;
import exceptionPackage.WrongNameException;

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

    public void save(BankAccountEntity bankAccountEntity) throws SQLException, Exception {
        validateAccount(bankAccountEntity);

        String accountNumber = bankAccountEntity.getAccountNumber();
        String queryString = "SELECT * FROM SAVINGS_ACCOUNT WHERE ACCOUNT_NUMBER='" + accountNumber + "'";
        ResultSet resultSet = dbConnection.createStatement().executeQuery(queryString);
        if (resultSet.next()) {
            String queryStringSave = "UPDATE SAVINGS_ACCOUNT SET balance = " + bankAccountEntity.getBalance() + " WHERE account_number = '" + accountNumber + "'";
            System.out.println(queryStringSave);
            dbConnection.createStatement().executeUpdate(queryStringSave);
        } else {
            String queryStringSave = "INSERT INTO SAVINGS_ACCOUNT(account_number, balance, open_time_stamp) VALUES ('"
                    + bankAccountEntity.getAccountNumber() + "'," + bankAccountEntity.getBalance() + "," + bankAccountEntity.getOpenTimeStamp() + ");";
            System.out.println(queryStringSave);
            dbConnection.createStatement().executeUpdate(queryStringSave);

        }

    }

    private void validateAccount(BankAccountEntity bankAccountEntity) throws Exception {
        if (!isValidateName(bankAccountEntity.getAccountNumber()))
            throw new WrongNameException();
        if (bankAccountEntity.getBalance() < 0)
            throw new NegativeBalaceException();
        if (bankAccountEntity.getOpenTimeStamp() < 0)
            throw new NegativeOpenTimeStampException();
    }

    private boolean isValidateName(String accountNumber) {
        if (accountNumber.length() != 10) return false;
        for (int i = 0; i < 10; i++)
            if (!((accountNumber.charAt(i) >= '0') && (accountNumber.charAt(i) <= '9')))
                return false;
        return true;
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
