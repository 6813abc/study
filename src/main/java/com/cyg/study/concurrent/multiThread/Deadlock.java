package com.cyg.study.concurrent.multiThread;

/**
 * 模拟死锁
 *
 * @author cyg
 * @date 2021/5/20 10:30
 **/
public class Deadlock {

    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println("获取锁1");
                System.out.println("等待获取锁2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {
                    System.out.println("获取锁2");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                System.out.println("获取锁2");
                System.out.println("等待获取锁1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {
                    System.out.println("获取锁1");
                }
            }
        }).start();
    }
}
