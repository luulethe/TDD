import dao.BankAccountDao;
import entity.BankAccountEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import presentation.BankAccount;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/19/13
 * Time: 2:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
    String accountNumber = "1234567890";
    BankAccountDao mockBankAccountDao = mock(BankAccountDao.class);
    double e = 0.00001;

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        BankAccount.setDao(mockBankAccountDao);
    }

    @Test
    public void testDeposit() {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccount.deposit(accountNumber, 100, "deposit money");
        verify(mockBankAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 1100, e);

    }
}
