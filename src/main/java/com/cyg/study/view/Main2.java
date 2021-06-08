package com.cyg.study.view;

import java.util.*;

/**
 * @author cyg
 * @date 2021/6/6 9:35
 **/
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        //LR,FB,AC
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        if (map.get('L') > map.get('R')) {
            map.put('L', map.get('L') - map.get('R'));
            map.remove('R');
        } else {
            map.put('R', map.get('R') - map.get('L'));
            map.remove('L');
        }
        if (map.get('F') > map.get('B')) {
            map.put('F', map.get('F') - map.get('B'));
            map.remove('B');
        } else {
            map.put('B', map.get('B') - map.get('F'));
            map.remove('F');
        }
        if (map.get('A') > map.get('C')) {
            map.put('A', map.get('A') - map.get('C'));
            map.remove('C');
        } else {
            map.put('C', map.get('C') - map.get('A'));
            map.remove('A');
        }
        map.replaceAll((c, v) -> v % 4);
        int pl = 1;
        int pz = 3;
        if (map.containsKey('L')) {
            int l = map.get('L');
            if (l == 1) {
                pl = 5;
            } else if (l == 2) {
                pl = 2;
            } else if (l == 3) {
                pl = 6;
            }
        } else {
            int r = map.get('R');
            if (r == 1) {
                pl = 6;
            } else if (r == 2) {
                pl = 2;
            } else if (r == 3) {
                pl = 5;
            }
        }
        if (map.containsKey('F')) {
            int f = map.get('F');
            if (f == 1) {
                pz = 5;
            } else if (f == 2) {
                pz = 4;
            } else if (f == 3) {
                pz = 6;
            }
        } else {
            int r = map.get('B');
            if (r == 1) {
                pz = 6;
            } else if (r == 2) {
                pz = 5;
            } else if (r == 3) {
                pz = 4;
            }
        }
        if (map.containsKey('A')) {
            int f = map.get('A');
            if (f == 1) {
                pl = 4;
                pz = 1;
            } else if (f == 2) {
                pl = 2;
                pz = 4;
            } else if (f == 3) {
                pl = 3;
                pz = 2;
            }
        } else {
            int b = map.get('B');
            if (b == 1) {
                pl = 3;
                pz = 2;
            } else if (b == 2) {
                pl = 2;
                pz = 4;
            } else if (b == 3) {
                pl = 4;
                pz = 1;
            }
        }
        if (pl == 1 && pz == 3) {
            System.out.println("123456");
        } else if (pl == 5 && pz == 3) {
            System.out.println("563421");
        } else if (pl == 6 && pz == 3) {
            System.out.println("653412");
        } else if (pl == 2 && pz == 3) {
            System.out.println("213456");
        }

    }
}
