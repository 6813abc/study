package com.cyg.study.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 *
 * @author cyg
 * @date 2021/6/2 17:11
 **/
public class AddStrings {

    public static String addStrings(String num1, String num2) {
        List<Integer> list = new ArrayList<>();
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int flag = 0;
        while (index1 > -1 || index2 > -1 || flag == 1) {
            int n1 = 0;
            int n2 = 0;
            if (index1 > -1) {
                n1 = Integer.parseInt(num1.substring(index1, index1 + 1));
            }
            if (index2 > -1) {
                n2 = Integer.parseInt(num2.substring(index2, index2 + 1));
            }
            int num = n1 + n2;
            if (flag == 1) {
                list.add((num + 1) % 10);
                flag = num + 1 >= 10 ? 1 : 0;
            } else {
                list.add(num % 10);
                flag = num >= 10 ? 1 : 0;
            }
            index1--;
            index2--;
        }
        StringBuilder re = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            re.append(list.get(i).toString());
        }
        return re.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("584", "18"));
    }
}
