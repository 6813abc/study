package com.cyg.study.algorithm.swordFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任一一个重复的数字。
 * 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，那么对应的输出是2或者3。存在不合法的输入的话输出-1
 *
 * @author cyg
 * @date 2021/6/15 16:08
 **/
public class Duplicate {
    public static int duplicate(int[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : numbers) {
            if (map.containsKey(number)){
                return number;
            }
            map.put(number, null);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{2, 1, 3, 1, 4}));
    }
}
