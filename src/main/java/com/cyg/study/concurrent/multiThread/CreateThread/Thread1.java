package com.cyg.study.concurrent.multiThread.CreateThread;

/**
 * 继承Thread类
 *
 * @author cyg
 * @date 2021/5/19 16:08
 **/
public class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("继承Thread类");
    }

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start();
    }
}
