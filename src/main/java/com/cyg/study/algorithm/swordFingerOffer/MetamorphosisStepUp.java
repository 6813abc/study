package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 3->4
 * 题解：
 * f(n) = f(n-1) + f(n-2) + ... + f(1)
 * f(n -1) = f(n-2) + f(n-3) + ... + f(1)
 * f(n) - f(n-1) = f(n-1)
 * f(n) = 2*f(n-1)
 *
 * @author cyg
 * @date 2020/11/3 10:12
 **/
public class MetamorphosisStepUp {

    public int JumpFloorII(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloorII(target - 1) * 2;
        }
    }

    public static void main(String[] args) {
        MetamorphosisStepUp metamorphosisStepUp = new MetamorphosisStepUp();
        System.out.println(metamorphosisStepUp.JumpFloorII(3));
    }
}
