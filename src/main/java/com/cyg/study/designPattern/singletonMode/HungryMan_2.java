package com.cyg.study.designPattern.singletonMode;

/**
 * 饿汉变种，采用静态代码块加载
 *
 * @author cyg
 * @date 2021/5/18 17:26
 **/
public class HungryMan_2 {
    private static final HungryMan_2 instance = null;

    static {
        HungryMan_2 instance = new HungryMan_2();
    }

    public static HungryMan_2 getInstance() {
        return instance;
    }
}
