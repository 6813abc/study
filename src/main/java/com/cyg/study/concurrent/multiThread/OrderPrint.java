package com.cyg.study.concurrent.multiThread;

/**
 * 启动3个线程A、B、C，使A打印0，而后B打印1，而后C打印2，A打印3，B打印4，C打印5，依次类推。并发
 *
 * @author cyg
 * @date 2021/5/12 11:49
 **/
public class OrderPrint {
    private static final Object lock = new Object();
    static int current = 1;

    public static void main(String[] args) {
        int threadCount = 3;
        int max = 100;
        for (int i = 0; i < threadCount; i++) {
            int finalI = i;
            new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        //判断是否轮到当前线程执行,轮不到就wait
                        if (current % threadCount == finalI) {
                            if (current > max) {
                                break;
                            }
                            System.out.println("thread-" + finalI + " : " + current);
                            current++;
                            //唤醒其余wait线程
                            lock.notifyAll();
                        }
                        try {
                            // 若不是，则当前线程进入wait
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }
    }
}
