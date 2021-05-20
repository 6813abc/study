package com.cyg.study.concurrent.multiThread.CreateThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口
 *
 * @author cyg
 * @date 2021/5/19 16:11
 **/
public class Thread3 implements Callable<String> {


    @Override
    public String call() throws Exception {
        System.out.println("实现Callable接口");
        return "实现Callable接口";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new Thread3());
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }
}
