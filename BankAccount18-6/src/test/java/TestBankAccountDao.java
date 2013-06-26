import dao.BankAccountDao;
import entity.BankAccountEntity;
import exceptionPackage.WrongNameException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.h2.jdbcx.JdbcDataSource;
import org.h2.tools.RunScript;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.sql.DataSource;
import java.nio.charset.Charset;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/23/13
 * Time: 8:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBankAccountDao {
    //using H2 so that we can create in-memory database for testing
    // without having to install any DBMS software
    private static final String JDBC_DRIVER = org.h2.Driver.class.getName();
    private static final String JDBC_URL = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final double e = 0.0000001;
    private static final String accountNumber = "0123456789";

    @BeforeClass
    public static void createSchema() throws Exception {
        String schemaFileName = System.class.getResource("/schema.sql").toString().substring(6);
        String temp = System.class.getResource("/schema.sql").toString();
        System.out.println(schemaFileName);
        System.out.println(temp);
        RunScript.execute(JDBC_URL, USER, PASSWORD, schemaFileName, Charset.forName("UTF8"), false);
    }

    // populate the table with test data
    @Before
    public void importDataSet() throws Exception {
        IDataSet dataSet = readDataSet();  // read data from xml file
        cleanlyInsert(dataSet);  // empty the db and insert data
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception {
        IDatabaseTester databaseTester = new JdbcDatabaseTester(JDBC_DRIVER, JDBC_URL, USER, PASSWORD);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    private IDataSet readDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }

    @Test
    public void testGetAccountNumber() throws Exception {
        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());
        BankAccountEntity account = bankAccountDao.getAccount(accountNumber);

        assertEquals("0123456789", account.getAccountNumber());
        assertEquals(100, account.getBalance(), e);
        assertEquals(12345678, account.getOpenTimeStamp());
    }

    @Test
    public void testGetAccountReturnNull() throws Exception {
        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());
        BankAccountEntity account = bankAccountDao.getAccount("0123456787");
        assertEquals(account, null);
    }

    @Test
    public void testSaveAnExitingAccount() throws Exception {
        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());

        BankAccountEntity account = bankAccountDao.getAccount(accountNumber);
        account.setBalance(1000);
        bankAccountDao.save(account);
        BankAccountEntity accountAfterSaving = bankAccountDao.getAccount(accountNumber);

        assertEquals(accountAfterSaving.getBalance(), 1000, e);
    }

    @Test
    public void testSaveNotExitingAccount() throws Exception {
        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());

        BankAccountEntity account = new BankAccountEntity("1234567890", 0);
        bankAccountDao.save(account);

        BankAccountEntity accountAfterSaving = bankAccountDao.getAccount("1234567890");

        assertEquals(accountAfterSaving.getAccountNumber(), "1234567890");
        assertEquals(accountAfterSaving.getBalance(), 0, e);
    }

    @Test(expected = WrongNameException.class)
    public void testSaveWithLengthOfAccountNameIsNot10() throws Exception {

        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());

        BankAccountEntity account = new BankAccountEntity("12345678", 0);
        bankAccountDao.save(account);
        fail("Exception expected");
    }

    @Test(expected = WrongNameException.class)
    public void testSaveWithAccountNameContainsNotDigit() throws Exception {

        BankAccountDao bankAccountDao = new BankAccountDao(dataSource());

        BankAccountEntity account = new BankAccountEntity("a123456789", 0);
        bankAccountDao.save(account);
        fail("Exception expected");
    }

    private DataSource dataSource() {
        JdbcDataSource dataSource = new JdbcDataSource();
        dataSource.setURL(JDBC_URL);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);
        return dataSource;
    }

}
