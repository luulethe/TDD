package presentation;

import dao.BankAccountDAO;
import entity.BankAccountEntity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/10/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDAO bankAccountDAO;

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        BankAccount.bankAccountDAO = bankAccountDAO;
    }

    public static BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDAO.getAccount(accountNumber);
    }

    public static void deposit(String accountNumber, int amount, String description) {
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        Transaction.createTransaction(accountNumber, amount, description);
        bankAccountDAO.save(bankAccountEntity);
    }

    public static void withdraw(String accountNumber, int amount, String description) {
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() - amount);
        Transaction.createTransaction(accountNumber, amount, description);
        bankAccountDAO.save(bankAccountEntity);
    }
}
