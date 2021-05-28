package com.cyg.study.concurrent.keyword;

/**
 * @author cyg
 * @date 2021/5/27 11:31
 **/
public class Volatile {

    private static int anInt = 0;
    private static volatile int anInt1 = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                anInt++;
                anInt1++;
            }).start();
        }
        System.out.println(anInt);
        System.out.println(anInt1);
    }
}
