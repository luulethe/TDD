package unitTest.unitTestService;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.business.impl.HistoryServiceImpl;
import com.qsoft.tictactoe.persistance.dao.HistoryDAO;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * User: trungpt
 * Date: 8/20/13
 * Time: 10:10 AM
 */
public class HistoryServiceTest
{
    HistoryDAO mockHistoryDAO = mock(HistoryDAO.class);
    HistoryService historyService = new HistoryServiceImpl();

    @Before
    public void setUp()
    {
        reset(mockHistoryDAO);
        historyService.setDao(mockHistoryDAO);
    }
    @Test
    public void testGetAllHistories()
    {
        historyService.getAllHistories();
        verify(mockHistoryDAO).getAllHistories();
    }
}
