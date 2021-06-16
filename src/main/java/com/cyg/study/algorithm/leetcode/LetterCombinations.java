package com.cyg.study.algorithm.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc,3-def,4-ghi,5-jkl,6-mno,7-pqrs,8-tuv,9-wxyz
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * @author cyg
 * @date 2021/6/16 14:46
 **/
public class LetterCombinations {

    public static List<String> letterCombinations(String digits) {
        String[] strings = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        Queue<String> queue = new ArrayDeque<>();
        for (int i = 0; i < digits.length(); i++) {
            String s = strings[Integer.parseInt(digits.charAt(i) + "") - 2];
            if (i == 0) {
                for (int j = 0; j < s.length(); j++) {
                    queue.add(s.charAt(j) + "");
                }
            } else {
                while (queue.peek() != null && queue.peek().length() == i) {
                    String s1 = queue.peek();
                    for (int p = 0; p < s.length(); p++) {
                        queue.add(s1 + s.charAt(p));
                    }
                    queue.poll();
                }
            }
        }
        while (queue.peek() != null) {
            result.add(queue.poll());
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }
}
