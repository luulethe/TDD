package unittest.dao;

import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 11:25 AM
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:testContext.xml"})
@TransactionConfiguration(defaultRollback = true)
// Importance, as the transaction will be rollback for each test
// give us a clean state.
@Transactional
public class HistoryDAOTest
{
    @Autowired
    private HistoryDAO historyDAO;
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
    public void testGetAllHistories()
    {
        List<History> historyList = historyDAO.getAllHistories();
        assertEquals(historyList.size(), 2);
        assertEquals(historyList.get(0).getFirstPlayer(), "X");
        assertEquals(historyList.get(0).getWinner(), "X");
        assertEquals(historyList.get(0).getSteps(), "1,2,3,4,5");

        assertEquals(historyList.get(1).getFirstPlayer(), "X");
        assertEquals(historyList.get(1).getWinner(), "O");
        assertEquals(historyList.get(1).getSteps(), "0,5,4,6,8");
    }
}