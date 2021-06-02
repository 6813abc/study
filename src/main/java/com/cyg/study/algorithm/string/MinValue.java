package com.cyg.study.algorithm.string;

import java.util.Arrays;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * @author cyg
 * @date 2021/6/2 9:41
 **/
public class MinValue {

    public static String minNumber(int[] nums) {
        int n = nums.length;
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, ((o1, o2) -> {
            String s1 = o1 + o2, s2 = o2 + o1;
            return s1.compareTo(s2);
        }));
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println(minNumber(arr));
    }
}
