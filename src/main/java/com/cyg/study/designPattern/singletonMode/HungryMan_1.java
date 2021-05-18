package com.cyg.study.designPattern.singletonMode;

/**
 * 饿汉
 *
 * @author cyg
 * @date 2021/5/18 17:26
 **/
public class HungryMan_1 {
    private static final HungryMan_1 instance = new HungryMan_1();

    public static HungryMan_1 getInstance() {
        return instance;
    }
}
