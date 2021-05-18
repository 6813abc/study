package com.cyg.study.designPattern.singletonMode;

/**
 * 双检锁实现单例模式
 *
 * @author cyg
 * @date 2021/5/18 16:43
 **/
public class DoubleCheckLock {

    private static volatile DoubleCheckLock INSTANCE = null;

    private static DoubleCheckLock getInstance() {
        if (INSTANCE == null) {
            synchronized (DoubleCheckLock.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DoubleCheckLock();
                }
            }
        }
        return INSTANCE;
    }

    private String getString() {
        return "111";
    }

    public static void main(String[] args) {
        DoubleCheckLock doubleCheckLock = DoubleCheckLock.getInstance();
        DoubleCheckLock doubleCheckLock1 = DoubleCheckLock.getInstance();
        System.out.println(doubleCheckLock == doubleCheckLock1);
    }
}
