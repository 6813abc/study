package com.cyg.study.concurrent.threadLocal;

/**
 * @author cyg
 * @date 2021/3/19 14:55
 **/
public class ThreadLocalTest {


    public static void main(String[] args) {
        test();
    }

    public static void test() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread thread1 = new Thread(() -> {
            threadLocal.set("111");
            System.out.println("threadLocal1:" + threadLocal.get());
        });
        Thread thread2 = new Thread(() -> {
            threadLocal.set("222");
            System.out.println("threadLocal1:" + threadLocal.get());
        });
        thread1.start();
        thread2.start();
    }
}
