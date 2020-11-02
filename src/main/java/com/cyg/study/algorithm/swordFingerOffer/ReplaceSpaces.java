package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author cyg
 * @date 2020/10/29 19:57
 **/
public class ReplaceSpaces {

    public String replaceSpace(StringBuffer str) {
        if (str == null || str.toString().length() == 0) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.toString().length(); i++) {
            if (str.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    public String replaceSpace1(StringBuffer str) {

        return null;
    }
}
