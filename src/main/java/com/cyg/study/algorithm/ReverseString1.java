package com.cyg.study.algorithm;

/**
 * 把括号内的字符串逆序，有嵌套
 * (abc(sgd)csa) ---> (ascsgdcba)
 *
 * @author cyg
 * @date 2020/11/2 17:18
 **/
public class ReverseString1 {

    public String reverseString(String str) {
        if (str.length() <= 1) {
            return str.equals("(") || str.equals(")") ? "" : str;
        }
        int i = 0;
        while (str.charAt(i) == '(' || str.charAt(i) == ')') {
            i++;
        }
        return reverseString(str.substring(i + 1)) + str.charAt(i);
    }

    public static void main(String[] args) {
        ReverseString1 reverseString = new ReverseString1();
        System.out.println(reverseString.reverseString("(abc(sgd)csa)"));
    }
}
