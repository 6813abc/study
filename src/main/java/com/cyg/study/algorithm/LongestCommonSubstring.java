package com.cyg.study.algorithm;

/**
 * 给定两个字符串str1和str2,输出两个字符串的最长公共子串，如果最长公共子串为空，输出-1。
 * "1AB2345CD","12345EF" -> "2345"
 *
 * @author cyg
 * @date 2020/11/4 16:33
 **/
public class LongestCommonSubstring {

    //暴力破解
    public static String force(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "";
        }
        int res = 0;
        String maxStr = "";
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                int m = i;
                int k = j;
                int len = 0;
                StringBuilder str = new StringBuilder();
                while (m < str1.length() && k < str2.length() && str1.charAt(m) == str2.charAt(k)) {
                    str.append(str1.charAt(m));
                    len++;
                    m++;
                    k++;
                }
                if (len > res) {
                    res = len;
                    maxStr = str.toString();
                }
            }
        }
        return maxStr;
    }

    //动态规则
    public static String LCS(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return "-1";
        }
        int maxLen = 0;
        String maxStr = "";
        int[][] s = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    s[i][j] = s[i - 1][j - 1] + 1;
                    if (s[i][j] > maxLen) {
                        maxLen = s[i][j];
                        maxStr = str2.substring(j - maxLen, j);
                    }
                }
            }
        }
        return maxStr.equals("") ? "-1" : maxStr;
    }


    public static void main(String[] args) {
        //暴力
        //System.out.println(LongestCommonSubstring.force("1AB2345CD", "12345EF"));
        //动态规划
        System.out.println(LongestCommonSubstring.LCS("1AB2345CD", "12345EF"));
    }
}
