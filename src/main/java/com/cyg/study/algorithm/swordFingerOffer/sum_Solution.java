package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 输入：
 * 5
 * 返回值：
 * 15
 *
 * @author cyg
 * @date 2021/6/8 17:17
 **/
public class sum_Solution {

    public static int Sum_Solution(int n) {
        boolean flag = n > 1 && (n += Sum_Solution(n - 1)) > 1;
        return n;
    }

    public static void main(String[] args) {
        System.out.println(Sum_Solution(5));
    }
}
