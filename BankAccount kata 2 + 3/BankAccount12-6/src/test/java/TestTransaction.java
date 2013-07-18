import dao.BankAccountDao;
import dao.TransactionDao;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import presentation.BankAccount;
import presentation.Transaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/13/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
    String accountNumber = "1234567890";
    BankAccountDao mockAccountDao = mock(BankAccountDao.class);
    TransactionDao mockTransactionDao = mock(TransactionDao.class);
    double e = 0.0001;

    @Before
    public void setUp() {
        reset(mockAccountDao);
        reset(mockTransactionDao);
        BankAccount.setDao(mockAccountDao);
        Transaction.setDao(mockTransactionDao);
    }

    @Test
    public void TestDeposit() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        BankAccount.deposit(accountNumber, 100, "deposit");
        verify(mockAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 1100, e);
    }

    @Test(expected = Exception.class)
    public void TestDepositWithDoNotExitAccount() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(null);

        BankAccount.deposit(accountNumber, 100, "deposit");
        fail("Exception expected");
        verify(mockAccountDao, never()).save(argument.capture());
    }

    @Test
    public void TestSaveTransactionDeposit() throws Exception {

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        Calendar mockCalendar = mock(Calendar.class);
        TransactionEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L, 2000L);

        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        BankAccount.deposit(accountNumber, 100, "deposit 0");
        BankAccount.deposit(accountNumber, 200, "deposit 1");

        verify(mockTransactionDao, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getDescription(), "deposit 0");
        assertEquals(list.get(0).getAmount(), 100, e);
        assertEquals(list.get(0).getTimeStamp(), 1000);

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getDescription(), "deposit 1");
        assertEquals(list.get(1).getAmount(), 200, e);
        assertEquals(list.get(1).getTimeStamp(), 2000);
    }

    @Test
    public void TestWithdraw() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        BankAccount.withdraw(accountNumber, 100, "deposit");
        verify(mockAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 900, e);
    }

    @Test(expected = Exception.class)
    public void TestWithdrawWithDoNotExitAccount() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(null);

        BankAccount.withdraw(accountNumber, 100, "deposit");
        fail("Exception expected");
        verify(mockAccountDao, never()).save(argument.capture());
    }

    @Test(expected = Exception.class)
    public void TestWithdrawDoNotEnoughMoney() throws Exception {
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        BankAccount.withdraw(accountNumber, 2000, "deposit");
        verify(mockAccountDao, never()).save(argument.capture());
    }

    @Test
    public void TestSaveTransactionWithdraw() throws Exception {

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        Calendar mockCalendar = mock(Calendar.class);
        TransactionEntity.setCalendar(mockCalendar);
        when(mockCalendar.getTimeInMillis()).thenReturn(1000L, 2000L);

        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        BankAccount.withdraw(accountNumber, 100, "withdraw 0");
        BankAccount.withdraw(accountNumber, 200, "withdraw 1");

        verify(mockTransactionDao, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getDescription(), "withdraw 0");
        assertEquals(list.get(0).getAmount(), 100, e);
        assertEquals(list.get(0).getTimeStamp(), 1000);

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getDescription(), "withdraw 1");
        assertEquals(list.get(1).getAmount(), 200, e);
        assertEquals(list.get(1).getTimeStamp(), 2000);
    }

    @Test
    public void TestGetTransactionsOccurred() {
        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        TransactionEntity trE1 = new TransactionEntity(accountNumber, 1000, "number 1");
        TransactionEntity trE2 = new TransactionEntity(accountNumber, 2000, "number 2");
        List<TransactionEntity> listResult = new ArrayList<TransactionEntity>();
        listResult.add(trE1);
        listResult.add(trE2);

        when(mockTransactionDao.TransactionsOccurred(accountNumber)).thenReturn(listResult);
        List<TransactionEntity> list = BankAccount.getTransactionsOccurred(accountNumber);
        assertEquals(listResult.size(), list.size());
        int i = 0;
        for (TransactionEntity trE : listResult) {
            assertTrue(trE.equals(list.get(i)));
            i++;
        }
    }

    @Test
    public void TestGetTransactionsOccurredBetweenTwoTime() {
        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        TransactionEntity trE1 = new TransactionEntity(accountNumber, 1000, "number 1");
        TransactionEntity trE2 = new TransactionEntity(accountNumber, 2000, "number 2");
        List<TransactionEntity> listResult = new ArrayList<TransactionEntity>();
        listResult.add(trE1);
        listResult.add(trE2);
        long startTime = 1000;
        long stopTime = 2000;
        when(mockTransactionDao.TransactionsOccurred(accountNumber, startTime, stopTime)).thenReturn(listResult);
        List<TransactionEntity> list = BankAccount.getTransactionsOccurred(accountNumber, startTime, stopTime);
        assertEquals(listResult.size(), list.size());
        int i = 0;
        for (TransactionEntity trE : listResult) {
            assertTrue(trE.equals(list.get(i)));
            i++;
        }
    }

    @Test
    public void TestGetNTransactionsOccurred() {
        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        TransactionEntity trE1 = new TransactionEntity(accountNumber, 1000, "number 1");
        TransactionEntity trE2 = new TransactionEntity(accountNumber, 2000, "number 2");
        List<TransactionEntity> listResult = new ArrayList<TransactionEntity>();
        listResult.add(trE1);
        listResult.add(trE2);
        int n = 2;
        when(mockTransactionDao.TransactionsOccurred(accountNumber, n)).thenReturn(listResult);
        List<TransactionEntity> list = BankAccount.getTransactionsOccurred(accountNumber, n);
        assertEquals(listResult.size(), list.size());
        int i = 0;
        for (TransactionEntity trE : listResult) {
            assertTrue(trE.equals(list.get(i)));
            i++;
        }
    }

}

