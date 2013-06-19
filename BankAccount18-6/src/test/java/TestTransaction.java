import dao.BankAccountDao;
import dao.TransactionDao;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import presentation.BankAccount;
import presentation.Transaction;

import java.util.List;

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
    TransactionDao mockTransactionDao = mock(TransactionDao.class);
    double e = 0.00001;

    @Before
    public void setUp() {
        reset(mockBankAccountDao);
        reset(mockBankAccountDao);
        BankAccount.setDao(mockBankAccountDao);
        Transaction.setDao(mockTransactionDao);

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

    @Test
    public void testSaveTransactionDeposit() {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);


        BankAccount.deposit(accountNumber, 100, "deposit money");
        BankAccount.deposit(accountNumber, 200, "deposit money1");

        verify(mockTransactionDao).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber() , accountNumber);
        assertEquals(list.get(0).getOpenTimeStamp() , 2000L);
        assertEquals(list.get(0).getAmount() , 100, e);
        assertEquals(list.get(0).getDescription() , "deposit money");

    }
}
