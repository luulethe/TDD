package Presentation;

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
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber,0);
        BankAccountDAO.save(bankAccountEntity);
        return bankAccountEntity;
    }

    public static void setBankAccountDAO(BankAccountDAO bankAccountDAO) {
        BankAccount.bankAccountDAO = bankAccountDAO;
    }

    public static BankAccountDAO getBankAccountDAO() {
        return bankAccountDAO;
    }
}
