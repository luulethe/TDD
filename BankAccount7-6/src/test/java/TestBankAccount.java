import entity.BankAccountEntity;
import org.junit.Before;
import org.junit.Test;
import presentation.BankAccount;
import dao.BankAccountDAO;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/7/13
 * Time: 5:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccount {
    BankAccountDAO mockAccountDao = mock(BankAccountDAO.class);
    static final double   e = 0.00001;

    @Before
    public void setUp() {
        reset(mockAccountDao);
    }

    @Test
    public void testOpenAccount() {
        BankAccount bankAccount = new BankAccount(mockAccountDao);
        BankAccountEntity bankAccountEntity = bankAccount.open("1234567890");
        assertEquals(bankAccountEntity.getBalance(), 0 ,e);
        verify(mockAccountDao).save(bankAccountEntity);
    }
}
