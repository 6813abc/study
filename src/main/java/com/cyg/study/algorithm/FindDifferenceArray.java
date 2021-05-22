package com.cyg.study.algorithm;


/**
 * 在一个有序的数组中，所有元素都是成对出现，但除了一个特殊元素外，请查找出该特殊元素在数组中的位置
 * @author cyg
 * @date 2021/5/22 11:28
 **/
public class FindDifferenceArray {

    private static int findDifferenceArray(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }
        int l1 = 0;
        int l2 = 1;
        while (l2 < arr.length) {
            if (arr[l1] != arr[l2]) {
                return l1;
            }
            l1 += 2;
            l2 += 2;
        }
        return arr.length - 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2, 3, 6, 6, 4, 4};
        System.out.println(findDifferenceArray(arr));
    }
}
