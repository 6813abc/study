package com.cyg.study.concurrent.multiThread.CreateThread;

/**
 * 继承Thread类
 *
 * @author cyg
 * @date 2021/5/19 16:08
 **/
public class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("实现Runnable接口");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Thread2());
        thread.start();
    }
}
