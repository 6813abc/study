package com.cyg.study.inter;

/**
 * @author cyg
 * @date 2021/5/8 9:37
 **/
public abstract class TestAbstract {

    public static void main(String[] args) {
        System.out.println(111);
    }

    public void eat(){
        System.out.println("父类实现：吃饭");
    }

    public void sleep(){
        System.out.println("父类实现：睡觉");
    }

    public abstract void jump();
}
