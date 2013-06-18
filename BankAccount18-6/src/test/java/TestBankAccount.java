import dao.BankAccountDao;
import entity.BankAccountEntity;
import org.junit.Before;
import org.junit.Test;
import presentation.BankAccount;

import java.util.Calendar;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/18/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    String accountNumber = "1234567890";
    double e = 0.0001;
    BankAccountDao mockBankAccountDao = mock(BankAccountDao.class);

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        BankAccount.setDao(mockBankAccountDao);
    }

    @Test
    public void testOpenAccount() {
        Calendar calendar = mock(Calendar.class);
        when(calendar.getTimeInMillis()).thenReturn(1000L);
        BankAccountEntity.setCalendar(calendar);

        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);

        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 0, e);
        assertEquals(bankAccountEntity.getOpenTimeStamp(), 1000L);

        verify(mockBankAccountDao).save(bankAccountEntity);

    }

    @Test
    public void testGetAccount() {
        BankAccountEntity bankAccountResult = BankAccount.open(accountNumber);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountResult);

        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);

        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 0, e);
        verify(mockBankAccountDao).getAccount(accountNumber);
    }
}
