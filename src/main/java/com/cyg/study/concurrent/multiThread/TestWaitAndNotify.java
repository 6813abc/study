package com.cyg.study.concurrent.multiThread;

import java.util.Arrays;
import java.util.List;

/**
 * wait方法和notify方法
 *
 * @author cyg
 * @date 2021/4/23 16:43
 **/
public class TestWaitAndNotify {

    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
        Object obj = new Object();
        new Thread(() -> {
            for (Object o : list1) {
                synchronized (obj) {
                    System.out.println(o);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(() -> {
            for (Object o : list2) {
                synchronized (obj) {
                    System.out.println(o);
                    obj.notify();
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
