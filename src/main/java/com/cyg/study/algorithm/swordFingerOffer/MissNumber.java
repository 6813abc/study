package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0~n-1之内。
 * 在范围0~n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * @author cyg
 * @date 2021/5/13 19:52
 **/
public class MissNumber {


    public static void main(String[] args) {

        System.out.println(getMissNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 8, 9}));
    }

    private static int getMissNumber(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                if (mid == 0 || nums[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
