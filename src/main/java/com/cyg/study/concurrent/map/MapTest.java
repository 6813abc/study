package com.cyg.study.concurrent.map;

import java.util.*;

/**
 * @author cyg
 * @date 2021/5/10 9:45
 **/
public class MapTest {
    public static void main(String[] args) {

        Map hashMap = new HashMap();
        hashMap = Collections.synchronizedMap(hashMap);

        List list = new ArrayList();
        list = Collections.singletonList(list);
    }
}
