package com.cyg.study.algorithm.string;

/**
 * 翻转字符串
 *
 * @author cyg
 * @date 2020/11/2 17:18
 **/
public class ReverseString {

    public String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("123456"));
    }
}
