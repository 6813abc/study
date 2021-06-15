package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 输入：
 * "We Are Happy"
 * 返回值：
 * "We%20Are%20Happy"
 *
 * @author cyg
 * @date 2021/6/8 17:28
 **/
public class ReplaceSpace {
    public String replaceSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                s = s.replace(" ", "%20");
            }
        }
        return s;
    }
}
