package com.cyg.study.concurrent.threadLocal;

/**
 * 子线程可共享父线程的副本数据 InheritableThreadLocal
 * InheritableThreadLocal是在new Thread中的init()方法给赋值的，而线程池是线程复用的逻辑，所以这里会存在问题。
 * 阿里巴巴开源了一个TransmittableThreadLocal组件就可以解决这个问题
 *
 * @author cyg
 * @date 2021/3/19 15:38
 **/
public class InheritableThreadLocalDemo {

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        //子线程可以共享父线程的线程副本数据
        ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        threadLocal.set("父类数据:threadLocal");
        inheritableThreadLocal.set("父类数据:inheritableThreadLocal");

        new Thread(() -> {
            System.out.println("子线程获取父类threadLocal数据：" + threadLocal.get());
            System.out.println("子线程获取父类inheritableThreadLocal数据：" + inheritableThreadLocal.get());
        }).start();
    }
}
