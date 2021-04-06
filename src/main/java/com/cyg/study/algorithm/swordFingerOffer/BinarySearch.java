package com.cyg.study.algorithm.swordFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 二分查找
 *
 * @author cyg
 * @date 2021/3/23 9:59
 **/
public class BinarySearch {

    public static int binarySearch(int[] array, int num) {
        int low = 0;
        int high = array.length - 1;
        int middle;
        if (num < array[low] || num > array[high]) {
            return -1;
        }
        while (low <= high) {
            //听说这样求平均值可以防止溢出
            //https://blog.csdn.net/as1072966956/article/details/79982623
            middle = (low & high) + ((low ^ high) >> 1);
            if (array[middle] == num) {
                return middle;
            } else if (array[middle] < num) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(array, 4));
        Map<String,String> map = new HashMap<>();
    }
}
