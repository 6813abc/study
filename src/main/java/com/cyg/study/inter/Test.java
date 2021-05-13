package com.cyg.study.inter;

/**
 * @author cyg
 * @date 2021/5/8 9:35
 **/
public class Test extends TestAbstract implements TestInterface {


    @Override
    public void drink() {
        System.out.println("特殊技能：喝");
    }

    @Override
    public void jump() {
        System.out.println("子类实现：跳");
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.eat();
        test.sleep();
        test.drink();
        test.jump();
    }
}
