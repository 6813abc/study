package com.cyg.study.concurrent.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author cyg
 * @date 2021/3/18 15:53
 **/
public class TestAtomic {
    private static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        test1();
        testAtomicInteger();
    }

    private static void test1() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i++;
            }
            cdl.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                i++;
            }
            cdl.countDown();
        });
        t1.start();
        t2.start();
        cdl.await();
        System.out.println("result=" + i);
    }

    private static void testAtomicInteger() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(2);
        AtomicInteger m = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                m.incrementAndGet();
            }
            cdl.countDown();
        });
        Thread t2 = new Thread(() -> {
            for (int j = 0; j < 5000; j++) {
                m.incrementAndGet();
            }
            cdl.countDown();
        });
        t1.start();
        t2.start();
        cdl.await();//让所有线程阻塞在这里，当所有的cdl.countDown();执行完后才解除阻塞
        System.out.println("result=" + m);
    }

    private static void testAtomicReference() throws InterruptedException {
    }
}
