package com.cyg.study.concurrent.multiThread;

/**
 * 开启 3 个线程，这三个线程的分别为 A、B、C，
 * 每一个线程打印对应的“A”、“B”、“C” 10 遍，要求输出的结果必须按顺序显示。
 * @author cyg
 * @date 2021/5/12 15:21
 **/
public class PrintABA {

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 10; i++) {
            Thread tc = new Thread(new C());
            tc.start();
            //等待线程tc结束，才继续执行主线程（main），可以设置超时时间
            tc.join();
        }
    }

    public static class A implements Runnable {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    public static class B implements Runnable {
        @Override
        public void run() {
            Thread ta = new Thread(new A());
            try {
                ta.start();
                ta.join();
                //等待线程ta结束
                System.out.println("B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class C implements Runnable {
        @Override
        public void run() {
            Thread tb = new Thread(new B());
            try {
                tb.start();
                //等到线程tb结束
                tb.join();
                System.out.println("C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}