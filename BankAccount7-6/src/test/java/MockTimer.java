import utils.MyTimer;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/8/13
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class MockTimer implements MyTimer {
    private static long currentTime = 0;

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public long getCurrentTime() {
        return currentTime;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
