package com.cyg.study.algorithm.view;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。
 *
 * @author cyg
 * @date 2021/6/4 17:40
 **/
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int count = 0;
        int ac = s2.charAt(0);
        for (int i = 0; i < s1.length(); i++) {
            int s = s1.charAt(i);
            if (s == ac || s - 32 == ac || s + 32 == ac) {
                count++;
            }
        }
        System.out.println(count);
    }
}
