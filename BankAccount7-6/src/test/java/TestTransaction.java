import presentation.BankAccount;
import presentation.Transaction;
import dao.BankAccountDAO;
import dao.TransactionDAO;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Calendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/11/13
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
    TransactionDAO mockTransactionDao = mock(TransactionDAO.class);
    BankAccountDAO mockAccountDao = mock(BankAccountDAO.class);
    String accountNumber = "1234567890";
    double e = 0.000001;

    @Before
    public void setUp() {
        reset(mockTransactionDao);
        reset(mockAccountDao);
        Transaction.setDao(mockTransactionDao);
        BankAccount.setBankAccountDAO(mockAccountDao);
    }

    @Test
    public void testDeposit() throws Exception{

        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);
        BankAccountEntity bankAccountEntityResult = new BankAccountEntity(accountNumber, 1000);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntityResult);

        BankAccount.deposit(accountNumber, 100, "deposit money");

        verify(mockAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 1100, e);


    }

    @Test
    public void testSaveTransactionDeposit() throws  Exception{
//        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
//        Calendar calendar = mock(Calendar.class);
//        TransactionEntity.setCalendar(calendar);
//        when(calendar.getTimeInMillis()).thenReturn(1000L);
//
//        BankAccountEntity bankAccountEntityResult = new BankAccountEntity(accountNumber, 1000);
//        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntityResult);
//        System.out.println("ok1");
//        System.out.println(Transaction.getTransactionDao());
//        BankAccount.deposit(accountNumber, 100, "deposit money");
//        System.out.println(mockTransactionDao);
//        System.out.println(Transaction.getTransactionDao());
//        verify(mockTransactionDao, times(1)).save(argument.capture());
//
//        List<TransactionEntity> list = argument.getAllValues();
//
//        assertEquals(list.get(0).getAccountNumber(), accountNumber);
//        assertEquals(list.get(0).getAmount(), 100);
//        assertEquals(list.get(0).getDescription(), "deposit money");
//        assertEquals(list.get(0).getTimeStamp(), 1000L);
        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 0);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        Calendar mockCalendar = mock(Calendar.class);
        TransactionEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L).thenReturn(2000L);
        BankAccount.deposit(accountNumber, 100, "send money");
        BankAccount.deposit(accountNumber, 200, "send money1");

        verify(mockTransactionDao, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getAmount(), 100, e);
        assertEquals(list.get(0).getDescription(), "send money");
        assertEquals(list.get(0).getTimestamp(), 1000);

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getAmount(), 200, e);
        assertEquals(list.get(1).getDescription(), "send money1");
        assertEquals(list.get(1).getTimestamp(), 2000);
    }
}
