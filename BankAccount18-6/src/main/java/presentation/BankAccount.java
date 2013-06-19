package presentation;

import dao.BankAccountDao;
import entity.BankAccountEntity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/18/13
 * Time: 1:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    private static BankAccountDao bankAccountDao;

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDao.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDao.getAccount(accountNumber);
    }

    public static void deposit(String accountNumber, int amount, String description) {
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        bankAccountEntity.setBalance(bankAccountEntity.getBalance() + amount);
        bankAccountDao.save(bankAccountEntity);
        Transaction.createTransaction(accountNumber, amount, description);
    }
}
