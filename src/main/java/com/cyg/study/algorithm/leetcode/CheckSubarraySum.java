package com.cyg.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：
 * 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数。
 * 如果存在，返回 true ；否则，返回 false 。
 *
 * @author cyg
 * @date 2021/6/2 15:36
 **/
public class CheckSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = (num + nums[i]) % k;
            if (i != 0 && num == 0) {
                return true;
            }
            if (map.containsKey(num)) {
                if (i - map.get(num) > 1) {
                    return true;
                }
            } else {
                map.put(num, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 3, 0, 4, 0, 4, 0};
        System.out.println(checkSubarraySum(arr, 5));
    }
}
