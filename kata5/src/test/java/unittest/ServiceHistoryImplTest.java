package unittest;

import com.qsoft.business.HistoryService;
import com.qsoft.business.impl.HistoryServiceImpl;
import com.qsoft.persistence.dao.HistoryDAO;
import com.qsoft.persistence.entity.History;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;

/**
 * User: luult
 * Date: 8/13/13
 * Time: 11:05 AM
 */
public class ServiceHistoryImplTest
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
        List<History> historyList = historyService.getAllHistories();
        verify(mockHistoryDAO).getAllHistories();
    }
}
