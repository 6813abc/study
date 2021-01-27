package com.cyg.study.algorithm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 * [[1,1,0,0,0],
 * [0,1,0,1,1],
 * [0,0,0,1,1],
 * [0,0,0,0,0],
 * [0,0,1,1,1]]          -> 3
 *
 * @author cyg
 * @date 2020/11/6 11:41
 **/
public class Solve {

    //ReentrantLock是Lock的子类
    private final Lock lock = new ReentrantLock();

    private void method(Thread thread) {
        lock.lock(); // 获取锁对象
        try {
            System.out.println("线程名：" + thread.getName() + "获得了锁");
            // Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("线程名：" + thread.getName() + "释放了锁");
            lock.unlock(); // 释放锁对象
        }
    }

    public int solve(char[][] grid) {
        return 0;
    }

    public static void main(String[] args) {
        Solve s = new Solve();
        Thread t1 = new Thread(() -> s.method(Thread.currentThread()), "t1");
        Thread t2 = new Thread(() -> s.method(Thread.currentThread()), "t2");
        t1.start();
        t2.start();
        List<String> list = new ArrayList<>();
    }
}
