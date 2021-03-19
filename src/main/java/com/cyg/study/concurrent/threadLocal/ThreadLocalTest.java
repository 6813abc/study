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
        Thread thread1 = new Thread(() -> {
            ThreadLocal<String> threadLocal1 = new ThreadLocal<>();
            ThreadLocal<String> threadLocal2 = new ThreadLocal<>();
            threadLocal1.set("111");
            threadLocal1.set("111-update");
            threadLocal2.set("222");
            System.out.println("threadLocal1:" + threadLocal1.get());
            System.out.println("threadLocal2:" + threadLocal2.get());
        });
        Thread thread2 = new Thread(() -> {
            ThreadLocal<String> threadLocal3 = new ThreadLocal<>();
            threadLocal3.set("333");
            System.out.println("threadLocal3:" + threadLocal3.get());
        });
        thread1.start();
        thread2.start();
    }
}
