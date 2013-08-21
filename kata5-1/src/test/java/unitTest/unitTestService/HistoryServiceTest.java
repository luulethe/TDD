package unitTest.unitTestService;

import com.qsoft.tictactoe.business.HistoryService;
import com.qsoft.tictactoe.business.impl.HistoryServiceImpl;
import com.qsoft.tictactoe.persistence.dao.HistoryDAO;
import com.qsoft.tictactoe.persistence.entity.History;
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

    @Test
    public void testSaveHistory()
    {
        History history = new History();
        historyService.save(history);
        verify(mockHistoryDAO).save(history);
    }
}
