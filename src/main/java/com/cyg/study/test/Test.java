package com.cyg.study.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author cyg
 * @date 2021/5/14 11:44
 **/
public class Test {

    public static void main(String[] args) {
        Map<String, String> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("7", "1");
        linkedHashMap.put("3", "2");
        linkedHashMap.put("9", "3");
        linkedHashMap.put("3", "2");
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getValue());
        }

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("6", "1");
        hashMap.put("2", "2");
        hashMap.put("7", "3");
        for (String key : hashMap.keySet()) {
            System.out.println(hashMap.get(key));
        }
    }
}
