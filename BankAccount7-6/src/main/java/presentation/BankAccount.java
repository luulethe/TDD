package presentation;

import dao.BankAccountDAO;
import entity.BankAccountEntity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 5:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    public BankAccount(BankAccountDAO bankAccountDAO) {
        this.bankAccountDAO = bankAccountDAO;
    }

    private static BankAccountDAO bankAccountDAO;

    public static BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public static void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        BankAccount.bankAccountDAO = bankAccountDAO;
    }

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void deposit(String accountNumber, int amount, String description) {
        doTransaction(accountNumber, amount, description);
        //To change body of created methods use File | Settings | File Templates.
    }

    private static void doTransaction(String accountNumber, int amount, String description) {
        BankAccountEntity bankAccountEntity = bankAccountDAO.getAccount(accountNumber);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        bankAccountDAO.save(bankAccountEntity);
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDAO.getAccount(accountNumber);
    }
}
