package com.cyg.study.concurrent.multiThread;

/**
 * 线程 A 通过 synchronized (resource1) 获得 resource1 的监视器锁，然后通过Thread.sleep(1000);
 * 让线程 A 休眠 1s 为的是让线程 B 得到执行然后获取到 resource2 的监视器锁。
 * 线程 A 和线程 B 休眠结束了都开始企图请求获取对方的资源，然后这两个线程就会陷入互相等待的状态，这也就产生了死锁。
 * <p>
 * 产生死锁必须具备以下四个条件：
 * <p>
 * 互斥条件：该资源任意一个时刻只由一个线程占用。
 * 请求与保持条件：一个进程因请求资源而阻塞时，对已获得的资源保持不放。
 * 不剥夺条件:线程已获得的资源在未使用完之前不能被其他线程强行剥夺，只有自己使用完毕后才释放资源。
 * 循环等待条件:若干进程之间形成一种头尾相接的循环等待资源关系。
 *
 * @author cyg
 * @date 2021/4/23 16:06
 **/
public class DeadLockDemo {

    private static final Object resource1 = new Object();//资源 1
    private static final Object resource2 = new Object();//资源 2

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (resource1) {
                System.out.println(Thread.currentThread().getName() + " get resource1");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting get resource2");
                synchronized (resource2) {
                    System.out.println(Thread.currentThread().getName() + " get resource2");
                }
            }
        }, "线程1");
        new Thread(() -> {
            synchronized (resource2) {
                System.out.println(Thread.currentThread().getName() + " get resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " waiting get resource1");
                synchronized (resource1) {
                    System.out.println(Thread.currentThread().getName() + " get resource1");
                }
            }
        }, "线程2").start();
    }
}
