package com.cyg.study.algorithm.array;

/**
 * 在有序数组中去掉重复的数字，返回一共有多少个不重复的数字
 *
 * @author cyg
 * @date 2021/5/20 17:17
 **/
public class OrderedArrayRemoveRepeat {

    public static int orderedArrayRemoveRepeat(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr.length;
        }
        int m = 0;
        int n = 1;
        int len = arr.length;
        while (n < arr.length) {
            if (arr[m] == arr[n]) {
                len--;
            }
            m++;
            n++;
        }
        return len;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 1};
        System.out.println(orderedArrayRemoveRepeat(arr));
    }
}
