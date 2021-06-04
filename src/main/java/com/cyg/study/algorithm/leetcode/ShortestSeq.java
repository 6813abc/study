package com.cyg.study.algorithm.leetcode;

import java.util.*;

/**
 * 假设你有两个数组，一个长一个短，短的元素均不相同。找到长数组中包含短数组所有的元素的最短子数组，其出现顺序无关紧要。
 * 返回最短子数组的左端点和右端点，如有多个满足条件的子数组，返回左端点最小的一个。若不存在，返回空数组。
 *
 * 实现复杂了，会出现超时的情况
 * @author cyg
 * @date 2021/6/3 15:03
 **/
public class ShortestSeq {
    public static int[] shortestSeq(int[] big, int[] small) {
        int l = 0;
        int r = 0;
        List<Integer> smallList = new ArrayList<>();
        List<Integer> l2r = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int m : small) {
            smallList.add(m);
        }
        for (Integer value : big) {
            int flag = 0;
            r++;
            l2r.add(value);
            while (l2r.containsAll(smallList)) {
                l2r.remove(new Integer(big[l]));
                l++;
                flag = 1;
            }
            if (flag == 1) {
                map.put(l - 1, r - 1);
            }
        }
        int smallL = 0;
        int smallR = 0;
        int min = Integer.MAX_VALUE;
        //System.out.println(map);
        for (Integer key : map.keySet()) {
            int r1 = map.get(key);
            if (r1 - key < min) {
                min = r1 - key;
                smallL = key;
                smallR = r1;
            }
        }
        if (smallL == 0 && smallR == 0) {
            return new int[]{};
        } else {
            return new int[]{smallL, smallR};
        }
    }

    public static void main(String[] args) {
        //int[] big = new int[]{842, 336, 777, 112, 789, 801, 922, 874, 634, 121, 390, 614, 179, 565, 740, 672, 624, 130, 555, 714, 9, 950, 887, 375, 312, 862, 304, 121, 360, 579, 937, 148, 614, 885, 836, 842, 505, 187, 210, 536, 763, 880, 652, 64, 272, 675, 33, 341, 101, 673, 995, 485, 16, 434, 540, 284, 567, 821, 994, 174, 634, 597, 919, 547, 340, 2, 512, 433, 323, 895, 965, 225, 702, 387, 632, 898, 297, 351, 936, 431, 468, 694, 287, 671, 190, 496, 80, 110, 491, 365, 504, 681, 672, 825, 277, 138, 778, 851, 732, 176};
        //int[] small = new int[]{950, 885, 702, 101, 312, 652, 555, 936, 842, 33, 634, 851, 174, 210, 287, 672, 994, 614, 732, 919, 504, 778, 340, 694, 880, 110, 777, 836, 365, 375, 536, 547, 887, 272, 995, 121, 225, 112, 740, 567, 898, 390, 579, 505, 351, 937, 825, 323, 874, 138, 512, 671, 297, 179, 277, 304};
        int[] big = new int[]{1, 2, 1, 2, 1, 2};
        int[] small = new int[]{1, 2};
        System.out.println(big.length);
        System.out.println(small.length);
        System.out.println(Arrays.toString(shortestSeq(big, small)));
    }
}
