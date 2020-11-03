package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法：
 * 2 -> 2
 * 3 -> 3
 * 4 -> 5
 *
 * @author cyg
 * @date 2020/11/3 10:34
 **/
public class RectangularCover {

    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }


    public static void main(String[] args) {
        RectangularCover rectangularCover = new RectangularCover();
        System.out.println(rectangularCover.RectCover(5));
    }
}
