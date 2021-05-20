package com.cyg.study.concurrent.multiThread.CreateThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 线程池创建
 *
 * @author cyg
 * @date 2021/5/19 16:11
 **/
public class Thread4 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(() -> System.out.println("线程池创建,Runnable"));
        executorService.execute(new FutureTask<String>(() -> {
            System.out.println("线程池创建,Callable");
            return "线程池创建,Callable";
        }));
    }
}
