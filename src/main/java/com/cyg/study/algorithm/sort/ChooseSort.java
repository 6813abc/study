package com.cyg.study.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author cyg
 * @date 2021/5/31 16:28
 **/
public class ChooseSort {

    private static int[] chooseSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int k = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[k]) {
                    k = j;
                }
            }
            if (i != k) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(chooseSort(new int[]{5, 7, 4, 6, 9, 6, 1, 5})));
    }
}
