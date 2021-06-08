package com.cyg.study.algorithm.view;

import java.util.Scanner;

/**
 * 将一个字符串str的内容颠倒过来，并输出。str的长度不超过100个字符。
 *
 * @author cyg
 * @date 2021/6/4 17:40
 **/
public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }
        System.out.println(builder.toString());
    }
}
