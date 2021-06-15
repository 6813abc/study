package com.cyg.study.algorithm.swordFingerOffer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author cyg
 * @date 2021/6/15 10:37
 **/
public class ReOrderArray {

    public static int[] reOrderArray(int[] array) {
        int left = 0;
        int right = 0;
        while (right < array.length - 1) {
            while (array[left] % 2 != 0) {
                left++;
                right++;
            }
            while (right + 1 < array.length && array[right + 1] % 2 == 0) {
                right++;
            }
            if (right < array.length - 1) {
                swap(left, right, array);
            }
            left++;
            right++;
        }
        return array;
    }

    private static void swap(int l, int r, int[] array) {
        int temp = array[r + 1];
        if (r + 1 - l >= 0) System.arraycopy(array, l, array, l + 1, r + 1 - l);
        array[l] = temp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(reOrderArray(new int[]{1, 3, 5, 7, 2, 4, 6})));
    }
}
