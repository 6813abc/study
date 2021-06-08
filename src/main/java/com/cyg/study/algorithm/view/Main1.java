package com.cyg.study.algorithm.view;

import java.util.Scanner;

/**
 * 描述
 * 计算字符串最后一个单词的长度，单词以空格隔开，字符串长度小于5000。
 * 输入描述：
 * 输入一行，代表要计算的字符串，非空，长度小于5000。
 * 输出描述：
 * 输出一个整数，表示输入字符串最后一个单词的长度。
 *
 * @author cyg
 * @date 2021/6/4 17:27
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int i = s.length() - 1;
        int count = 0;
        while (i > -1 && s.charAt(i) != ' ') {
            count++;
            i--;
        }
        System.out.println(count);
    }
}
