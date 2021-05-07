package com.cyg.study.concurrent.multiThread;

import org.springframework.http.server.reactive.AbstractListenerWriteFlushProcessor;

import java.util.concurrent.*;

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
