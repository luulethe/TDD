package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.business.impl.BankAccountServiceImpl;
import com.qsoft.bankaccount.business.impl.TransactionServiceImpl;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.dao.TransactionDAO;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import com.qsoft.bankaccount.persistence.model.TransactionEntity;
import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
/**
 * User: luult
 * Date: 7/3/13
 * Time: 10:02 PM
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:testContext.xml"})
public class TransactionServiceTest
{
    String accountNumber = "1234567890";
    BankAccountDAO mockBankAccountDao = mock(BankAccountDAO.class);
    TransactionDAO mockTransactionDao = mock(TransactionDAO.class);
    BankAccountService bankAccountService = new BankAccountServiceImpl();
    TransactionService transactionService = new TransactionServiceImpl();
    final double e = 0.00001;

    @Before
    public void setUp()
    {
        reset(mockBankAccountDao);
        reset(mockTransactionDao);
        bankAccountService.setDao(mockBankAccountDao);
        transactionService.setDao(mockTransactionDao);
    }

    @Test
    public void testDeposit() throws Exception
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);

        bankAccountService.setDao(mockBankAccountDao);

        bankAccountService.deposit(accountNumber, 100, "deposit money");
        verify(mockBankAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 1100, e);
    }

    @Test(expected = Exception.class)
    public void testDepositDoNotExitAccount() throws Exception
    {
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(null);
        bankAccountService.deposit(accountNumber, 100, "deposit money");
        fail("Exception expected");
    }

    @Test
    public void testSaveTransactionDeposit() throws Exception
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        Calendar mockCalendar = mock(Calendar.class);
        when(mockCalendar.getTimeInMillis()).thenReturn(2000L, 4000L);
        TransactionEntity.setCalendar(mockCalendar);

        bankAccountService.deposit(accountNumber, 100, "deposit money");
        bankAccountService.deposit(accountNumber, 200, "deposit money1");

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
    public void testWithdraw() throws Exception
    {

        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);
        ArgumentCaptor<BankAccountEntity> argument = ArgumentCaptor.forClass(BankAccountEntity.class);

        bankAccountService.withdraw(accountNumber, 100, "withdraw money");
        verify(mockBankAccountDao, times(1)).save(argument.capture());

        assertEquals(argument.getValue().getAccountNumber(), accountNumber);
        assertEquals(argument.getValue().getBalance(), 900, e);
    }

    @Test(expected = Exception.class)
    public void testWithdrawDoNotExitAccount() throws Exception
    {
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(null);
        bankAccountService.withdraw(accountNumber, 100, "withdraw money");
        fail("Exception expected");
    }

    @Test(expected = Exception.class)
    public void testWithdrawDoNotMoney() throws Exception
    {

        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        bankAccountService.withdraw(accountNumber, 2000, "withdraw money");
        fail("Exception expected");
    }

    @Test
    public void testSaveTransactionWithdraw() throws Exception
    {
        BankAccountEntity bankAccountEntity = new BankAccountEntity(accountNumber, 1000);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountEntity);

        ArgumentCaptor<TransactionEntity> argument = ArgumentCaptor.forClass(TransactionEntity.class);
        Calendar mockCalendar = mock(Calendar.class);
        when(mockCalendar.getTimeInMillis()).thenReturn(2000L, 4000L);
        TransactionEntity.setCalendar(mockCalendar);

        bankAccountService.withdraw(accountNumber, 100, "withdraw money");
        bankAccountService.withdraw(accountNumber, 200, "withdraw money1");

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
    public void testGetTransactionOccurred() throws Exception
    {
        List<TransactionEntity> list = bankAccountService.getTransactionsOccurred(accountNumber);
    }

    @Test
    public void testGetTransactionOccurredBetweenTwoTime() throws Exception
    {
        long startTime = 1000;
        long stopTime = 2000;
        List<TransactionEntity> list = bankAccountService.getTransactionsOccurred(accountNumber, startTime, stopTime);
    }

    @Test
    public void testGetNTransaction() throws Exception
    {
        int n = 2;
        List<TransactionEntity> list = bankAccountService.getTransactionsOccurred(accountNumber, n);
    }

}
