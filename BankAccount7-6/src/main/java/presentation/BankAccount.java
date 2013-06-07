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

    private BankAccountDAO bankAccountDAO;

    public BankAccountEntity open(String accountNumber) {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 0);
        bankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }
}
