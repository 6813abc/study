package com.cyg.study.algorithm;

import java.util.Arrays;

/**
 * 给定两个有序整数数组array1和array2，
 * 将 array2合并到 array1中，使得 array1成为一个有序数组。
 * 初始化 array1和 array2的元素数量分别为 m 和 n，
 * array1有足够的空间（空间大小大于或等于 m + n）来保存 array2中的元素。
 *
 * @author cyg
 * @date 2021/5/12 16:06
 **/
public class MergeArray {

    public static void main(String[] args) {
        int[] array1 = new int[10];
        array1[0] = 1;
        array1[1] = 3;
        array1[2] = 5;
        array1[3] = 7;
        array1[4] = 9;
        int[] array2 = new int[]{2, 4, 6, 8, 10};
        System.out.println(Arrays.toString(mergeArray(array1, array2, 5)));
    }

    /**
     * @param m a数组的数据量
     **/
    private static int[] mergeArray(int a[], int b[], int m) {
        m = m - 1;
        int n = b.length - 1;
        int k = a.length - 1;
        while (m >= 0 || n >= 0) {
            if (n < 0 || b[n] < a[m]) {
                a[k] = a[m];
                if (k != m) {
                    a[m] = 0;
                }
                m--;
            } else if (b[n] >= a[m]) {
                a[k] = b[n];
                n--;
            }
            k--;
        }
        return a;
    }
}
