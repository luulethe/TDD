import Presentation.BankAccount;
import dao.BankAccountDAO;
import entity.BankAccountEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/10/13
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestAccount {
    static String accountNumber = "1234567890";
    BankAccountDAO mockAccountDAO = mock(BankAccountDAO.class);
    double e = 0.000001;

    @Before
    public void setUp() {
        reset(mockAccountDAO);
        BankAccount.setBankAccountDAO(mockAccountDAO);
    }

    @Test
    public void testOpenAccount() {
        Calendar mockCalendar = mock(Calendar.class);
        BankAccountEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);
        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);
        verify(mockAccountDAO).save(bankAccountEntity);
        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 0, e);
        assertEquals(bankAccountEntity.getOpenTimeStamp(), 1000L);
    }
    @Test
    public void testGetAccount() {
        BankAccountEntity bankAccountEntityResult = new BankAccountEntity(accountNumber,1000);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityResult);

        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);

        verify(mockAccountDAO).getAccount(accountNumber);
        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 1000, e);
    }
}
