import dao.BankAccountDAO;
import dao.TransactionDAO;
import entity.BankAccountEntity;
import entity.TransactionEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import presentation.BankAccount;
import presentation.Transaction;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 10:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestTransaction {
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
    public void testDeposit() {
        ArgumentCaptor<BankAccountEntity> argument = org.mockito.ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 0);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);
        BankAccount.deposit(accountNumber, 100, "send money");

        verify(mockAccountDAO, times(2)).save(argument.capture());
        assertEquals(argument.getAllValues().get(1).getAccountNumber(), accountNumber);
        assertEquals(argument.getAllValues().get(1).getBalance(), 100, e);
    }

    @Test
    public void testSaveTransactionDeposit() {

        ArgumentCaptor<TransactionEntity> argument = org.mockito.ArgumentCaptor.forClass(TransactionEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 0);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);
        BankAccount.deposit(accountNumber, 100, "send money");
        BankAccount.deposit(accountNumber, 200, "send money1");

        verify(mockTransactionDAO, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getAmount(), 100, e);
        assertEquals(list.get(0).getDescription(), "send money");
        //assertEquals(list.get(0).getTimestamp(), System.currentTimeMillis());

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getAmount(), 200, e);
        assertEquals(list.get(1).getDescription(), "send money1");
    }

    @Test
    public void testWithdraw() {
        ArgumentCaptor<BankAccountEntity> argument = org.mockito.ArgumentCaptor.forClass(BankAccountEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 100);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);
        BankAccount.Withdraw(accountNumber, 50, "withdraw money");
        BankAccount.Withdraw(accountNumber, 20, "withdraw money");

        verify(mockAccountDAO, times(3)).save(argument.capture());
        assertEquals(argument.getAllValues().get(2).getAccountNumber(), accountNumber);
        assertEquals(argument.getAllValues().get(2).getBalance(), 30, e);
    }

    @Test
    public void testSaveTransactionWidth() {

        ArgumentCaptor<TransactionEntity> argument = org.mockito.ArgumentCaptor.forClass(TransactionEntity.class);

        BankAccountEntity bankAccountEntityFromDatabase = new BankAccountEntity(accountNumber, 500);
        when(mockAccountDAO.getAccount(accountNumber)).thenReturn(bankAccountEntityFromDatabase);
        BankAccountEntity bankAccountEntity = BankAccount.open(accountNumber);
        BankAccount.Withdraw(accountNumber, 100, "withdraw money");
        BankAccount.Withdraw(accountNumber, 200, "withdraw money1");

        verify(mockTransactionDAO, times(2)).save(argument.capture());
        List<TransactionEntity> list = argument.getAllValues();

        assertEquals(list.get(0).getAccountNumber(), accountNumber);
        assertEquals(list.get(0).getAmount(), -100, e);
        assertEquals(list.get(0).getDescription(), "withdraw money");
        //assertEquals(list.get(0).getTimestamp(), System.currentTimeMillis());

        assertEquals(list.get(1).getAccountNumber(), accountNumber);
        assertEquals(list.get(1).getAmount(), -200, e);
        assertEquals(list.get(1).getDescription(), "withdraw money1");
    }

}
