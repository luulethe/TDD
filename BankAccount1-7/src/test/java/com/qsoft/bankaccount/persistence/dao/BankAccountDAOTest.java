package com.qsoft.bankaccount.persistence.dao;

import com.qsoft.bankaccount.persistence.dao.impl.BankAccountDAOImpl;
import com.qsoft.bankaccount.persistence.model.BankAccountEntity;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.IDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static junit.framework.Assert.assertEquals;

/**
 * User: luult
 * Date: 7/3/13
 * Time: 11:14 PM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
// Importance, as the transaction will be rollback for each test
// give us a clean state.
@Transactional
public class BankAccountDAOTest
{
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private BankAccountDAO bankAccountDAO;
    final static String accountNumber = "0123456789";
    final static double e = 0.00001;
    @Autowired
    private DataSource dataSourceTest;

    private IDatabaseTester databaseTester;

    @Before
    public void setup() throws Exception
    {
        IDataSet dataSet = readDataSet();  // read data from xml file
        cleanlyInsert(dataSet);  // empty the db and insert data
    }

    private IDataSet readDataSet() throws Exception
    {
        return new FlatXmlDataSetBuilder().build(System.class.getResource("/dataset.xml"));
    }

    private void cleanlyInsert(IDataSet dataSet) throws Exception
    {
        databaseTester = new DataSourceDatabaseTester(dataSourceTest);
        databaseTester.setSetUpOperation(DatabaseOperation.CLEAN_INSERT);
        databaseTester.setDataSet(dataSet);
        databaseTester.onSetup();
    }

    @After
    public void tearDown() throws Exception
    {
        databaseTester.onTearDown();
    }

    @Test
    public void testGetAccount() throws Exception
    {
        BankAccountEntity account = bankAccountDAO.getAccount(accountNumber);

        assertEquals("0123456789", account.getAccountNumber());
        assertEquals(100, account.getBalance(), e);
        assertEquals(12345678, account.getOpenTimeStamp());
    }

    @Test
    public void testGetAccountReturnNull() throws Exception
    {
        BankAccountEntity account = bankAccountDAO.getAccount("0123456787");
        assertEquals(account, null);
    }

    @Test
    public void testSaveAnExistingAccount() throws Exception {
        BankAccountEntity account = bankAccountDAO.getAccount(accountNumber);
        account.setBalance(2000);
        bankAccountDAO.save(account);

        entityManager.detach(account);
        BankAccountEntity accountAfterSaving = bankAccountDAO.getAccount(accountNumber);

        assertEquals(accountAfterSaving.getBalance(), 2000, e);
    }

    @Test
    public void testSave() throws Exception
    {

    }
}
