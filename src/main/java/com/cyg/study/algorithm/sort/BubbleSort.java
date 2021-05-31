package com.cyg.study.algorithm.sort;

import java.util.Arrays;

/**
 * @author cyg
 * @date 2021/5/31 16:45
 **/
public class BubbleSort {

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(bubbleSort(new int[]{5, 7, 4, 6, 9, 6, 1, 5})));
    }
}
