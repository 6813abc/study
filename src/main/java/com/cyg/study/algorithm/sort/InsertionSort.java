package com.cyg.study.algorithm.sort;

import java.util.Arrays;

/**
 * 直接插入排序
 *
 * @author cyg
 * @date 2021/5/14 17:38
 **/
public class InsertionSort {

    static void insertionSort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int x = a[i];
                while (j >= 0 && x < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = x;
            }
            System.out.println("第" + i + "次：" + Arrays.toString(a));
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 5, 7, 2, 4, 9, 6};
        insertionSort(a);
    }
}
