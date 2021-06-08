package com.cyg.study.algorithm.view;

import java.util.Scanner;

/**
 * 描述
 * <p>
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 输入描述：
 * 输入一个整数（int类型）
 * 输出描述：
 * 这个数转换成2进制后，输出1的个数
 *
 * @author cyg
 * @date 2021/6/4 17:40
 **/
public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int count = 0;
        while (n != 0) {
            if (n % 2 == 1) {
                count++;
            }
            n = n / 2;
        }
        System.out.println(count);
    }
}
