package com.cyg.study.base;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 *
 * @author cyg
 * @date 2021/3/19 16:51
 **/
public class Generic {

    public static void main(String[] args) throws Exception {
        testAdd();
    }

    public static void testAdd() throws Exception {
        List<Integer> list = new ArrayList<>();
        list.add(12);
        //这里直接添加会报错
        //list.add("a");
        Method add = list.getClass().getMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");
        System.out.println(list);
    }
}
