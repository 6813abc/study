package com.cyg.study.base;

import java.lang.reflect.Field;

/**
 * @author cyg
 * @date 2020/9/4 16:47
 **/
public class cache {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        Class cache = Integer.class.getDeclaredClasses()[0];
        Field myCache = cache.getDeclaredField("cache");
        myCache.setAccessible(true);

        Integer[] newCache = (Integer[]) myCache.get(cache);
        //newCache[133] = 5，newCache[132] = 4
        newCache[132] = newCache[133];

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b);
    }
}
