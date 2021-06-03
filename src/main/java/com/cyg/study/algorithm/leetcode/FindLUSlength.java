package com.cyg.study.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定字符串列表，你需要从它们中找出最长的特殊序列。最长特殊序列定义如下：该序列为某字符串独有的最长子序列（即不能是其他字符串的子序列）。
 * 子序列可以通过删去字符串中的某些字符实现，但不能改变剩余字符的相对顺序。空序列为所有字符串的子序列，任何字符串为其自身的子序列。
 * 输入将是一个字符串列表，输出是最长特殊序列的长度。如果最长特殊序列不存在，返回 -1 。
 *
 * @author cyg
 * @date 2021/6/3 9:16
 **/
public class FindLUSlength {

    public static int findLUSlength(String[] strs) {
        Map<String, Boolean> map = new HashMap<>();
        for (String str : strs) {
            int flag = 0;
            for (String key : map.keySet()) {
                if (isSon(key, str)) {
                    flag = 1;
                }
                if (isSon(str, key)) {
                    map.put(key, false);
                }
            }
            map.put(str, flag != 1);
        }
        int maxLength = -1;
        for (String key : map.keySet()) {
            if (Boolean.parseBoolean(map.get(key).toString())) {
                maxLength = Math.max(key.length(), maxLength);
            }
        }
        return maxLength;
    }

    private static boolean isSon(String parent, String son) {
        int p = 0;
        int s = 0;
        while (p < parent.length() && s < son.length()) {
            if (parent.charAt(p) == son.charAt(s)) {
                s++;
            }
            p++;
        }
        return s == son.length();
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"aaaaa", "aaaaa", "aaa", "aaa", "aaaaaa", "a", "b", "c"};
        System.out.println(findLUSlength(strs));
        //System.out.println(isSon("aaa", "aaa"));
    }
}
