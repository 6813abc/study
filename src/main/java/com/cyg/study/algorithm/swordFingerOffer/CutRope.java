package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * @author cyg
 * @date 2021/6/15 16:18
 **/
public class CutRope {

    public static int cutRope(int target) {
        if (target == 0) return 0;
        if (target == 1 || target == 2) return 1;
        if (target == 3) return 2;
        int m = 1;
        while (target > 0) {
            if (target == 4 || target == 2) {
                m *= target;
                return m;
            }
            m *= 3;
            target = target - 3;
        }
        return m;
    }

    public static void main(String[] args) {
        System.out.println(cutRope(17));
    }
}
