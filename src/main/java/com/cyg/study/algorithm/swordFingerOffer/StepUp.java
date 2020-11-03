package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 1->1
 * 4->5
 *
 * @author cyg
 * @date 2020/11/3 10:00
 **/
public class StepUp {
    public int JumpFloor(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    public static void main(String[] args) {
        StepUp stepUp = new StepUp();
        System.out.println(stepUp.JumpFloor(4));
    }
}
