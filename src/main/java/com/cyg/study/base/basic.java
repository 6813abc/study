package com.cyg.study.base;

import java.util.Scanner;

/**
 * @author cyg
 * @date 2021/3/19 17:21
 **/
public class basic {


    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }


    private static void test3() {
        String a = "ab";
        System.out.println(a.hashCode());
        a = "abc";
        System.out.println(a.hashCode());
    }

    private static void test1() {
        String a = "ab";
        String b = "ab";
        //有常量池的原因，所有 a==b 是true
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }

    private static void test2() {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        Long h = 2L;

        System.out.println(c == d);//调用Integer.valueOf拆箱，[-128，127]的数据会在Integer.cache中查找，所以a,b是同一对象
        System.out.println(e == f);//调用Integer.valueOf拆箱，[-128，127]的数据会在Integer.cache中查找，所以e,f不是是同一对象
        System.out.println(c == (a + b));//右侧是表达式，会拆箱，比较数值
        System.out.println(c.equals(a + b));//两侧都是Integer，会先类型校验，再拆箱比较数值
        System.out.println(g == (a + b));//左侧Long，右侧Integer，向上转型，比较数值
        System.out.println(g.equals(a + b));//左侧Long，右侧Integer，类型不一样，直接false
        System.out.println(g.equals(a + h));//左侧Long，右侧向上转型为Long，类型一样，比较数值

        Integer i1 = 1;
        Integer i2 = new Integer(1);
        System.out.println(i1 == i2);//比较地址，由于i2是new的，不会涉及Integer.cache，所以地址不一样
        System.out.println(i1.equals(i2));//拆箱比较数值
    }
}
