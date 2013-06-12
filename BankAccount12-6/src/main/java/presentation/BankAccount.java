package presentation;

import dao.BankAccountDao;
import entity.BankAccountEntity;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/12/13
 * Time: 1:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankAccount {
    static BankAccountDao bankAccountDao;

    public static BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDao.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setDao(BankAccountDao bankAccountDao) {
        BankAccount.bankAccountDao = bankAccountDao;
    }

    public static BankAccountEntity getAccount(String accountNumber) {
        return bankAccountDao.getAccount(accountNumber);  //To change body of created methods use File | Settings | File Templates.
    }
}
