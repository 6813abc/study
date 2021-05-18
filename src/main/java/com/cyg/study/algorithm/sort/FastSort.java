package com.cyg.study.algorithm.sort;

import java.util.Arrays;

/**
 * Fast排序
 *
 * @author cyg
 * @date 2021/5/14 17:38
 **/
public class FastSort {

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);
            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }

    }

    static int getIndex(int[] a, int l, int r) {
        int tmp = a[l];
        while (l < r) {
            while (l < r && a[r] > tmp) {
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] < tmp) {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = tmp;
        return l;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 1, 5, 7, 2, 4, 9, 6};
        quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }
}
