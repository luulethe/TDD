import entity.BankAccountEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import presentation.BankAccount;
import dao.BankAccountDAO;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    BankAccountDAO mockAccountDAO = mock(BankAccountDAO.class);
    static final double e = 0.00001;
    static String accountNumber = "1234567890";

    @Before
    public void setUp() {
        reset(mockAccountDAO);
        BankAccount.setBankAccountDAO(mockAccountDAO);
    }

    @Test
    public void testOpenAccountAndPersistent() {
        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);

        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 0, e);
        verify(mockAccountDAO).save(bankAccountEntity);
    }

    @Test
    public void testGetAccount() {
        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 100);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);

        verify(mockAccountDAO).getAccount(accountNumber);
        assertEquals(bankAccountEntity, bankAccountEntityFromDatabase);
    }



}
