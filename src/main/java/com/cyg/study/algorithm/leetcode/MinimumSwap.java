package com.cyg.study.algorithm.leetcode;

/**
 * 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 * 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 * 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 * 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 * @author cyg
 * @date 2021/6/4 9:54
 **/
public class MinimumSwap {
    public static int minimumSwap(String s1, String s2) {
        if (s1.equals(s2)) {
            return 0;
        }
        int count = 0;
        int count1 = 0;//xy
        int count2 = 0;//yx
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) == 'x') {
                    count1++;
                } else {
                    count2++;
                }
            }
        }
        int c1 = count1 / 2;
        int c2 = count2 / 2;
        count += c1 + c2;
        count1 = c1 == count1 / 2.0 ? 0 : 1;
        count2 = c2 == count2 / 2.0 ? 0 : 1;
        if (count1 != count2) {
            return -1;
        } else if (count1 == 1) {
            count += 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(minimumSwap("xy", "yx"));
        System.out.println(minimumSwap("xx", "yy"));
        System.out.println(minimumSwap("xx", "xy"));
        System.out.println(minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
        //yx
        //xy
        //xx
        //yy
    }

}
