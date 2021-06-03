package com.cyg.study.algorithm.leetcode;

/**
 * 对于一个 正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 *
 * @author cyg
 * @date 2021/6/3 11:50
 **/
public class CheckPerfectNumber {

    public static boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 0;
        for (int i = 2; i < num / i; i++) {
            double temp = (double) num / i;
            if (temp == (int) temp) {
                sum += temp + i;
            }
        }
        return sum + 1 == num;
    }

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }
}
