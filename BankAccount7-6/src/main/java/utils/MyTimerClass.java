package utils;

/**
 * Created with IntelliJ IDEA.
 * User: luult
 * Date: 6/8/13
 * Time: 9:48 AM
 * To change this template use File | Settings | File Templates.
 */
public class MyTimerClass implements MyTimer {
    @Override
    public long getCurrentTime() {
        return System.currentTimeMillis();  //To change body of implemented methods use File | Settings | File Templates.
    }
}
