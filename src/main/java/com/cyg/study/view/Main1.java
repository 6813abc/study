package com.cyg.study.view;

import java.util.*;

/**
 * @author cyg
 * @date 2021/6/6 9:35
 **/
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        if (m <= 1 || m >= 100) {
            System.out.println("ERROR");
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                list.add(i);
                map.put(i, 1);
            }
            int start = 1;
            int count = 100;
            while (count >= m) {
                int p = m;
                while (p > 1) {
                    if (map.get(start) == 1) {
                        p--;
                    }
                    start++;
                    if (start > 100) {
                        start = 1;
                    }
                }
                while (map.get(start) == 0) {
                    start++;
                    if (start > 100) {
                        start = 1;
                    }
                }
                list.remove(new Integer(start));
                map.put(start, 0);
                count--;
                start++;
                if (start > 100) {
                    start = 1;
                }
            }
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
                if (i != list.size() - 1) {
                    System.out.print(",");
                }
            }
        }
    }
}
