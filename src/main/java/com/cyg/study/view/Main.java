package com.cyg.study.view;

import java.security.Key;
import java.util.*;

/**
 * @author cyg
 * @date 2021/6/6 9:35
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] nums = s.split(",");
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (String value : nums) {
            int num = Integer.parseInt(value);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
            set.add(num);
        }
        //1,3,3,3,2,4,4,4,5
        while (set.size() > 0) {
            int flag = 0;
            int maxKey = 0;
            int maxValue = 0;
            for (Integer key : map.keySet()) {
                int value = map.get(key);
                if (set.contains(key)) {
                    if (flag == 0) {
                        if (map.get(key) >= maxValue) {
                            maxValue = value;
                            maxKey = key;
                            flag = 1;
                        }
                    } else {
                        if (map.get(key) > maxValue) {
                            maxValue = value;
                            maxKey = key;
                        }
                    }
                }
            }
            set.remove(maxKey);
            System.out.print(maxKey);
            if (set.size() >= 1) {
                System.out.print(",");
            }
        }
    }
}