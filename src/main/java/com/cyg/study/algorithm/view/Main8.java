package com.cyg.study.algorithm.view;

import java.util.Scanner;

/**
 * 功能:等差数列 2，5，8，11，14。。。。
 * 输入:正整数N >0
 * 输出:求等差数列前N项和
 * 本题为多组输入，请使用while(cin>>)等形式读取数据
 * 输入描述：
 * 输入一个正整数。
 * 输出描述：
 * 输出一个相加后的整数。
 *
 * @author cyg
 * @date 2021/6/4 17:40
 **/
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int count = 0;
            int f = 2;
            for (int i = 0; i < n; i++) {
                count = count + f;
                f += 3;
            }
            System.out.println(count);
        }
    }
}
