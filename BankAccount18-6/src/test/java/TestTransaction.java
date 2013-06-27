import dao.BankAccountDao;
import dao.TransactionDao;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import exceptionPackage.DoNotExitAccountException;
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
        reset(mockTransactionDao);
        BankAccount.setDao(mockBankAccountDao);
        Transaction.setDao(mockTransactionDao);
    }

    @Test
    public void testDeposit() throws Exception {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccount.deposit(accountNumber, 100, "deposit money");
        verify(mockBankAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 1100, e);
    }

    @Test(expected = DoNotExitAccountException.class)
    public void testDepositDoNotExitAccount() throws Exception {
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(null);
        BankAccount.deposit(accountNumber, 100, "deposit money");
        fail("Exception expected");
    }

    @Test
    public void testSaveTransactionDeposit() throws Exception {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        Calendar mockCalendar = mock(Calendar.class);
        when(mockCalendar.getTimeInMillis()).thenReturn(2000L, 4000L);
        TransactionEntity.setCalendar(mockCalendar);

        BankAccount.deposit(accountNumber, 100, "deposit money");
        BankAccount.deposit(accountNumber, 200, "deposit money1");

        verify(mockTransactionDao, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getOpenTimeStamp(), 2000L);
        assertEquals(list.get(0).getAmount(), 100, e);
        assertEquals(list.get(0).getDescription(), "deposit money");

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getOpenTimeStamp(), 4000L);
        assertEquals(list.get(1).getAmount(), 200, e);
        assertEquals(list.get(1).getDescription(), "deposit money1");
    }

    @Test
    public void testWithdraw() throws Exception {

        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccount.withdraw(accountNumber, 100, "withdraw money");
        verify(mockBankAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 900, e);
    }

    @Test(expected = DoNotExitAccountException.class)
    public void testWithdrawDoNotExitAccount() throws Exception {
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(null);
        BankAccount.withdraw(accountNumber, 100, "withdraw money");
        fail("Exception expected");
    }

    @Test(expected = Exception.class)
    public void testWithdrawDoNotMoney() throws Exception {

        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        BankAccount.withdraw(accountNumber, 2000, "withdraw money");
        fail("Exception expected");
    }

    @Test
    public void testSaveTransactionWithdraw() throws Exception {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        Calendar mockCalendar = mock(Calendar.class);
        when(mockCalendar.getTimeInMillis()).thenReturn(2000L, 4000L);
        TransactionEntity.setCalendar(mockCalendar);

        BankAccount.withdraw(accountNumber, 100, "withdraw money");
        BankAccount.withdraw(accountNumber, 200, "withdraw money1");

        verify(mockTransactionDao, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getOpenTimeStamp(), 2000L);
        assertEquals(list.get(0).getAmount(), 100, e);
        assertEquals(list.get(0).getDescription(), "withdraw money");

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getOpenTimeStamp(), 4000L);
        assertEquals(list.get(1).getAmount(), 200, e);
        assertEquals(list.get(1).getDescription(), "withdraw money1");
    }

    @Test
    public void testGetTransactionOccurred() throws Exception{
        List<TransactionEntity> list = BankAccount.getTransactionsOccurred(accountNumber);
    }

    @Test
    public void testGetTransactionOccurredBetweenTwoTime() throws Exception{
        long startTime = 1000;
        long stopTime = 2000;
        List<TransactionEntity> list = BankAccount.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    @Test
    public void testGetNTransaction() throws Exception {
        int n = 2;
        List<TransactionEntity> list = BankAccount.getTransactionsOccurred(accountNumber, n);
    }

//    @Test
//    public void testGetNTransaction1() {
//        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
//
//        List<TransactionEntity> listTransaction = new ArrayList<TransactionEntity>();
//        listTransaction.add(new TransactionEntity("12",12,"122"));
//        System.out.println("cccccccccccccccc");
//        when(BankAccount.getTransactionsOccurred("0123456789")).thenReturn(listTransaction);
//
//        System.out.println(BankAccount.getTransactionsOccurred("0123456789"));
//        verify(BankAccount.getTransactionsOccurred(argument.capture()));
//       // System.out.println(argument.getValue());
//
//        //verify(mockTransactionDao).findOneTime("0123456789",1000L,1200L);
//    }
}
