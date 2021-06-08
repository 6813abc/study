package com.cyg.study.algorithm.view;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 定义一个单词的“兄弟单词”为：交换该单词字母顺序，而不添加、删除、修改原有的字母就能生成的单词。
 * 兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
 * 现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，字典序第k大的那个单词是什么？
 * 注意：字典中可能有重复单词。本题含有多组输入数据。
 * 输入描述：
 * 先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
 * 输出描述：
 * 输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
 * 示例1
 * 输入：
 * 3 abc bca cab abc 1
 * 输出：
 * 2
 * bca
 *
 * @author cyg
 * @date 2021/6/4 17:40
 **/
public class Main7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String s = scanner.next();
            list.add(s);
        }
        String x = scanner.next();
        int k = scanner.nextInt();
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (x.equals(s) || x.length() != s.length()) {
                list.remove(i--);
                continue;
            }
            for (int j = 0; j < s.length(); j++) {
                String s1 = s.replace(s.charAt(j) + "", "");
                String x1 = x.replace(s.charAt(j) + "", "");
                if (s1.length() != x1.length()) {
                    list.remove(i--);
                    break;
                }
            }
        }
        list.sort(String::compareTo);
        System.out.println(list.size());
        if (list.size() >= k) {
            System.out.println(list.get(k - 1));
        }
    }
}
