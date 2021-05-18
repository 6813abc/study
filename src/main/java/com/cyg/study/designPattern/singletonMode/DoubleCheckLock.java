package com.cyg.study.designPattern.singletonMode;

/**
 * @author cyg
 * @date 2021/5/18 16:43
 **/
public class DoubleCheckLock {

    private static volatile DoubleCheckLock doubleCheckLock = null;

    private static DoubleCheckLock getInstance() {
        if (doubleCheckLock == null) {
            synchronized (DoubleCheckLock.class) {
                if (doubleCheckLock == null) {
                    doubleCheckLock = new DoubleCheckLock();
                }
            }
        }
        return doubleCheckLock;
    }

    public static void main(String[] args) {
        DoubleCheckLock doubleCheckLock = DoubleCheckLock.getInstance();
        DoubleCheckLock doubleCheckLock1 = DoubleCheckLock.getInstance();
        System.out.println(doubleCheckLock == doubleCheckLock1);
    }
}
