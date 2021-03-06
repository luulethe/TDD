import dao.BankAccountDAO;
import dao.TransactionDAO;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import presentation.BankAccount;
import presentation.Transaction;
import sun.util.resources.LocaleNames_ga;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction1 {
    TransactionDAO mockTransactionDAO = mock(TransactionDAO.class);
    BankAccountDAO mockAccountDAO = mock(BankAccountDAO.class);
    static final double e = 0.00001;
    static String accountNumber = "1234567890";

    @Before
    public void setUp() {
        reset(mockTransactionDAO);
        reset(mockAccountDAO);
        Transaction.setDao(mockTransactionDAO);
        BankAccount.setBankAccountDAO(mockAccountDAO);
    }

    @Test
    public void testDeposit() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = org.mockito.ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 0);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccount.deposit(accountNumber, 100, "send money");

        verify(mockAccountDAO, times(1)).save(argument.capture());
        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 100, e);
    }

    @Test
    public void testSaveTransactionDeposit() throws Exception {

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 0);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        Calendar mockCalendar = mock(Calendar.class);
        TransactionEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L).thenReturn(2000L);
        BankAccount.deposit(accountNumber, 100, "send money");
        BankAccount.deposit(accountNumber, 200, "send money1");

        verify(mockTransactionDAO, times(2)).save(argument.capture());
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

    @Test
    public void testWithdraw() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = org.mockito.ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 100);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccount.Withdraw(accountNumber, 50, "withdraw money");
        BankAccount.Withdraw(accountNumber, 20, "withdraw money");

        verify(mockAccountDAO, times(2)).save(argument.capture());
        assertEquals(argument.getAllValues().get(1).getAccountNumber(), accountNumber);
        assertEquals(argument.getAllValues().get(1).getBalance(), 30, e);
    }

    @Test(expected = Exception.class)
    public void testWithdrawRaiseException() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = org.mockito.ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 100);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);

        BankAccount.Withdraw(accountNumber, 200, "withdraw money");

        verify(mockAccountDAO, times(0)).save(argument.capture());
    }

    @Test
    public void testSaveTransactionWithdraw() throws Exception {

        ArgumentCaptor<TransactionEntity> argument = org.mockito.ArgumentCaptor.forClass(TransactionEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 500);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);

        Calendar mockCalendar = mock(Calendar.class);
        TransactionEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L).thenReturn(2000L);

        BankAccount.Withdraw(accountNumber, 100, "withdraw money");
        BankAccount.Withdraw(accountNumber, 200, "withdraw money1");

        verify(mockTransactionDAO, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getAmount(), -100, e);
        assertEquals(list.get(0).getDescription(), "withdraw money");
        assertEquals(list.get(0).getTimestamp(), 1000);

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getAmount(), -200, e);
        assertEquals(list.get(1).getDescription(), "withdraw money1");
        assertEquals(list.get(1).getTimestamp(), 2000);
    }

    @Test
    public void testGetAllTransaction() {
        List<TransactionEntity> listResult = new ArrayList<TransactionEntity>();
        listResult.add(new TransactionEntity(accountNumber, 100, "deposit"));
        listResult.add(new TransactionEntity(accountNumber, 50, "withdraw"));

        when(mockTransactionDAO.getTransactionsOccurred(accountNumber)).thenReturn(listResult);
        List<TransactionEntity> listTransaction = BankAccount.getTransactionsOccurred(accountNumber);
        verify(mockTransactionDAO).getTransactionsOccurred(accountNumber);

        assertEquals(listTransaction.size(), listResult.size());
        int i = 0;
        for (TransactionEntity tr : listResult) {
            assertEquals(tr, listTransaction.get(i));
            i++;
        }
    }

    @Test
    public void testGetTransactionBetween2Time() {
        List<TransactionEntity> listResult = new ArrayList<TransactionEntity>();
        listResult.add(new TransactionEntity(accountNumber, 100, "deposit"));
        listResult.add(new TransactionEntity(accountNumber, 50, "withdraw"));

        long startTime = 10;
        long stopTime = 1000;
        when(mockTransactionDAO.getTransactionsOccurred(accountNumber, startTime, stopTime)).thenReturn(listResult);
        List<TransactionEntity> listTransaction = BankAccount.getTransactionsOccurred(accountNumber, startTime, stopTime);
        verify(mockTransactionDAO).getTransactionsOccurred(accountNumber, startTime, stopTime);

        assertEquals(listTransaction.size(), listResult.size());
        int i = 0;
        for (TransactionEntity tr : listResult) {
            assertEquals(tr, listTransaction.get(i));
            i++;
        }
    }

    @Test
    public void testGetNLatestTransaction() throws Exception {

        List<TransactionEntity> listResult = new ArrayList<TransactionEntity>();
        listResult.add(new TransactionEntity(accountNumber, 100, "deposit"));
        listResult.add(new TransactionEntity(accountNumber, 50, "withdraw"));

        long times = 2;
        when(mockTransactionDAO.getTransactionsOccurred(accountNumber, times)).thenReturn(listResult);
        List<TransactionEntity> listTransaction = BankAccount.getTransactionsOccurred(accountNumber, times);
        verify(mockTransactionDAO).getTransactionsOccurred(accountNumber, times);

        assertEquals(listTransaction.size(), listResult.size());
        int i = 0;
        for (TransactionEntity tr : listResult) {
            assertEquals(tr, listTransaction.get(i));
            i++;
        }
    }

    @Test(expected = Exception.class)
    public void testGetNLatestTransactionRaiseException() throws Exception {
        long times = -2;
        when(mockTransactionDAO.getTransactionsOccurred(accountNumber, times)).thenReturn(null);
        List<TransactionEntity> listTransaction = BankAccount.getTransactionsOccurred(accountNumber, times);
        verify(mockTransactionDAO).getTransactionsOccurred(accountNumber, times);
    }

}
