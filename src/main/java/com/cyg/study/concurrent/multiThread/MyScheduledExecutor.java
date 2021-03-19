package com.cyg.study.concurrent.multiThread;

/**
 * @author cyg
 * @date 2021/3/17 17:24
 **/
public class MyScheduledExecutor implements Runnable {

    private String jobName;

    MyScheduledExecutor(String jobName) {
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println(jobName + " is running" + "，线程名：" + Thread.currentThread().getName());
    }
}
