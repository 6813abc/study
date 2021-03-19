package com.cyg.study.concurrent.multiThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author cyg
 * @date 2021/3/17 17:21
 **/
public class ScheduledExecutorTest {

    private static int j = 0;

    public static void main(String[] args) throws InterruptedException {

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);

        scheduledThreadPool.scheduleAtFixedRate(new MyScheduledExecutor("job1"), 1, 1, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(new MyScheduledExecutor("job2"), 1, 1, TimeUnit.SECONDS);
        Thread.sleep(1000000);
        scheduledThreadPool.shutdown();
    }
}
