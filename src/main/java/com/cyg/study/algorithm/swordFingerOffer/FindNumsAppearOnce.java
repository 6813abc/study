package com.cyg.study.algorithm.swordFingerOffer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author cyg
 * @date 2021/6/15 14:16
 **/
public class FindNumsAppearOnce {

    public int[] findNumsAppearOnce(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int m : array) {
            if (!map.containsKey(m)) {
                map.put(m, null);
            } else {
                map.remove(m);
            }
        }
        array = new int[2];
        int i = 0;
        for (int key : map.keySet()) {
            array[i] = key;
            i++;
        }
        if (array[0] > array[1]) {
            int temp = array[0];
            array[0] = array[1];
            array[1] = temp;
        }
        return array;
    }

    public static int[] findNumsAppearOnce1(int[] array) {
        int c = array[0];
        for (int i = 1; i < array.length; i++) {
            c ^= array[i];
        }
        //求从右往左第一个1
        int tmp = c - (c & (c - 1));
        int val1 = 0;
        for (int val : array) {
            if ((val & tmp) == 0) {
                val1 ^= val;
            }
        }
        tmp = c ^ val1;
        int val2 = Math.max(tmp, val1);
        val1 = tmp + val1 - val2;
        return new int[]{val1, val2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findNumsAppearOnce1(new int[]{2, 4, 3, 6, 3, 2, 5, 5})));
    }
}
