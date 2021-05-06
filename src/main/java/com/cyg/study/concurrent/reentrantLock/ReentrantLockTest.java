package com.cyg.study.concurrent.reentrantLock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cyg
 * @date 2021/5/6 11:15
 **/
public class ReentrantLockTest {

    private static final Lock lock = new ReentrantLock(true);
    private static volatile int count;

    public static void incr(int i) {
        lock.lock();
        try {
            System.out.println(i + ":" + count++);
            //count++;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                incr(finalI);
            }, "");
            thread.start();
        }
    }
}
