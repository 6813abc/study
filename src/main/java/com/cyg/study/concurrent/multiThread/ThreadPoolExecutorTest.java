package com.cyg.study.concurrent.multiThread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cyg
 * @date 2021/5/7 17:14
 **/
public class ThreadPoolExecutorTest {


    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 100,
                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1), Executors.defaultThreadFactory(), new ThreadPoolExecutor.DiscardPolicy());
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(new MyScheduledExecutor("job" + i));
        }
    }
}
