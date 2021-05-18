package com.cyg.study.designPattern.singletonMode;


/**
 * 静态内部类实现单例模式
 *
 * @author cyg
 * @date 2021/5/18 17:10
 **/
public class StaticInternalClass {


    private static class InternalClass {
        private static final InternalClass INSTANCE = new InternalClass();
    }

    public static InternalClass getInstance() {
        return InternalClass.INSTANCE;
    }

    public static void main(String[] args) {
        InternalClass internalClass = StaticInternalClass.getInstance();
        InternalClass internalClass1 = StaticInternalClass.getInstance();
        System.out.println(internalClass == internalClass1);
    }
}
