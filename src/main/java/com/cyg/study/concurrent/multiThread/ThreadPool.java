package com.cyg.study.concurrent.multiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author cyg
 * @date 2021/3/17 17:01
 **/
public class ThreadPool {

    /**
     * https://www.jianshu.com/p/f030aa5d7a28
     **/
    public void createThreadPool() {
        // 返回一个固定线程数量的线程池。该线程池中的线程数量始终不变。当有一个新的任务提交时，线程池中若有空闲线程，则立即执行。
        // 若没有，则新的任务会被暂存在一个任务队列中，待有线程空闲时，便处理在任务队列中的任务。
        // workQueue 为LinkedBlockingQueue（无界阻塞队列），队列最大值为Integer.MAX_VALUE。如果任务提交速度持续大余任务处理速度，
        // 会造成队列大量阻塞。因为队列很大，很有可能在拒绝策略前，内存溢出。是其劣势；
        // 适用场景：可用于Web服务瞬时削峰，但需注意长时间持续高峰情况造成的队列阻塞。
        Executors.newFixedThreadPool(4);

        // 方法返回一个只有一个线程的线程池。若多余一个任务被提交到该线程池，任务会被保存在一个任务队列中，待线程空闲，按先入先出的顺序执行队列中的任务
        Executors.newSingleThreadExecutor();

        // 该方法返回一个可根据实际情况调整线程数量的线程池。线程池的线程数量不确定，但若有空闲线程可以复用，则会优先使用可复用的线程。
        // 若所有线程均在工作，又有新的任务提交，则会创建新的线程处理任务。所有线程在当前任务执行完毕后，将返回线程池进行复用。
        // workQueue 为 SynchronousQueue 同步队列，这个队列类似于一个接力棒，入队出队必须同时传递，因为CachedThreadPool线程创建无限制，不会有队列等待，所以使用SynchronousQueue；
        // 适用场景：快速处理大量耗时较短的任务，如Netty的NIO接受请求时，可使用
        Executors.newCachedThreadPool();

        // 多线程定时任务
        Executors.newScheduledThreadPool(4);

        // 上面几种线程池的创建都是使用的ThreadPoolExecutor的构造方法
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new FutureTask<T>(runnable, value);
    }


}
