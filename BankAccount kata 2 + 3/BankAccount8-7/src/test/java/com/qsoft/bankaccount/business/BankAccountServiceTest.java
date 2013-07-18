package com.qsoft.bankaccount.business;

import com.qsoft.bankaccount.business.impl.BankAccountServiceImpl;
import com.qsoft.bankaccount.persistence.dao.BankAccountDAO;
import com.qsoft.bankaccount.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 10:01 PM
 */
public class BankAccountServiceTest
{
    String accountNumber = "1234567890";
    double e = 0.0001;
    BankAccountDAO mockBankAccountDao = mock(BankAccountDAO.class);
    BankAccountService bankAccountService = new BankAccountServiceImpl();

    @Before
    public void setUp()
    {
        reset(mockBankAccountDao);
        bankAccountService.setDao(mockBankAccountDao);
    }

    @Test
    public void testOpenAccount() throws Exception
    {
        Calendar calendar = mock(Calendar.class);
        when(calendar.getTimeInMillis()).thenReturn(1000L);
        BankAccountEntity.setCalendar(calendar);

        BankAccountEntity bankAccountEntity = bankAccountService.open(accountNumber);

        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 0, e);
        assertEquals(bankAccountEntity.getOpenTimeStamp(), 1000L);

        verify(mockBankAccountDao).save(bankAccountEntity);
    }

    @Test
    public void testGetAccount() throws Exception
    {
        BankAccountEntity bankAccountResult = bankAccountService.open(accountNumber);
        when(mockBankAccountDao.getAccount(accountNumber)).thenReturn(bankAccountResult);

        BankAccountEntity bankAccountEntity = bankAccountService.getAccount(accountNumber);

        assertEquals(bankAccountEntity.getAccountNumber(), accountNumber);
        assertEquals(bankAccountEntity.getBalance(), 0, e);
        verify(mockBankAccountDao).getAccount(accountNumber);
    }
}
