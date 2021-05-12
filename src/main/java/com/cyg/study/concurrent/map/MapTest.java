package com.cyg.study.concurrent.map;

import java.util.HashMap;

/**
 * jdk1.6复现
 *
 * @author cyg
 * @date 2021/5/10 9:45
 **/
public class MapTest {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap(2, 0.75f);
        hashMap.put(5, 55);
        new Thread(() -> {
            hashMap.put(7, 77);
            System.out.println(hashMap);
        }).start();
        new Thread(() -> {
            hashMap.put(3, 33);
            System.out.println(hashMap);
        }).start();
        System.out.println(hashMap.get(5));
        System.out.println(hashMap.get(7));
        System.out.println(hashMap.get(3));
    }
}
