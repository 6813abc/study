package com.cyg.study.base;

/**
 * 不用做任何比较判断运算符找出两个整数中的较大的值
 *
 * @author cyg
 * @date 2021/5/27 14:45
 **/
public class CompareInt {
    private static int compareInt(int a, int b) {
        int c = (a - b) >>> 31;
        return a - (a - b) * c;
    }

    public static void main(String[] args) {
        System.out.println(compareInt(7, 8));
    }
}
