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
 * Date: 6/12/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestAccount {
    BankAccountDao mockBankAccountDao = mock(BankAccountDao.class);
    String accountNumber = "1234567890";
    double e = 0.00001;

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        BankAccount.setDao(mockBankAccountDao);
    }

    @Test
    public void testOpenAccount() {
        Calendar mockCalendar = mock(Calendar.class);
        BankAccountEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L);

        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);
        verify(mockBankAccountDao, times(1)).save(bankAccountEntity);

        assertEquals(bankAccountEntity.getBalance(), 0, e);
        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getOpenTimeStamp(), 1000L);
    }

    @Test
    public void testGetAccount() {
        BankAccountEntity bankAccountEntityResult = new BankAccountEntity(accountNumber, 2000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntityResult);

        BankAccountEntity bankAccountEntity = BankAccount.getAccount(accountNumber);
        verify(mockBankAccountDao).getAccount(accountNumber);

        assertEquals(bankAccountEntity.getBalance(), 2000, e);
        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
    }
}
