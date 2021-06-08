package com.cyg.study.algorithm.view;

import java.util.Scanner;

/**
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 *
 * @author cyg
 * @date 2021/6/4 17:40
 **/
public class Main9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.contains(".")) {
                System.out.println(ip2Int(s));
            } else {
                System.out.println(int2Ip(Long.parseLong(s)));
            }
        }

    }

    private static long ip2Int(String s) {
        String[] ips = s.split("\\.");
        long count = 0;
        for (int i = 0; i < ips.length; i++) {
            int index = 0;
            if (i == 0) {
                index = 24;
            } else if (i == 1) {
                index = 16;
            } else if (i == 2) {
                index = 8;
            }
            int ip = Integer.parseInt(ips[i]);
            while (ip != 0) {
                if (ip % 2 == 1) {
                    count += Math.pow(2, index);
                }
                ip = ip / 2;
                index++;
            }
        }
        return count;
    }

    private static String int2Ip(long n) {
        long[] ips = new long[32];
        int len = 31;
        while (n != 0) {
            ips[len] = n % 2;
            n = n / 2;
            len--;
        }
        int l = 8;
        StringBuilder b = new StringBuilder();
        int num = 0;
        for (int i = 0; i < 32; i++) {
            l--;
            if (ips[i] == 1) {
                num += Math.pow(2, l);
            }
            if (l == 0) {
                l = 8;
                b.append(num);
                if (i != 31) {
                    b.append(".");
                }
                num = 0;
            }
        }
        return b.toString();
    }
}
