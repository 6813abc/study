package com.cyg.study.jvm;

/**
 * @author cyg
 * @date 2021/1/29 16:06
 **/
public class GcTest {

    //添加配置 -XX:+PrintGCDetails
    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[30900 * 1024];
        allocation2 = new byte[3090 * 1024];
        allocation3 = new byte[900 * 1024];
        allocation4 = new byte[900 * 1024];
    }
}
