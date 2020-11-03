package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 输出斐波拉契数列的第n项
 *
 * @author cyg
 * @date 2020/11/3 9:54
 **/
public class Fibonacci {

    public int Fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return Fibonacci(n - 1) + Fibonacci(n - 2);
        }
    }
}
