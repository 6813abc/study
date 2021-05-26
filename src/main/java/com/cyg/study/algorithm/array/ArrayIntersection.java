package com.cyg.study.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 求两个有序数组的交集
 *
 * @author cyg
 * @date 2021/5/22 17:46
 **/
public class ArrayIntersection {


    /**
     * 双指针从前遍历
     **/
    private static List<Integer> arrayIntersection(int[] a, int[] b) {
        List<Integer> integers = new ArrayList<>();
        if (a.length == 0 || b.length == 0) {
            return integers;
        }
        int i = 0;
        int j = 0;
        while (i < a.length - 1 && j < b.length - 1) {
            if (a[i] < b[j]) {
                i++;
            } else if (a[i] == b[j]) {
                integers.add(a[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int[] arr2 = new int[]{5, 6, 7, 8, 9, 10, 11};
        System.out.println(arrayIntersection(arr1, arr2));
    }
}
