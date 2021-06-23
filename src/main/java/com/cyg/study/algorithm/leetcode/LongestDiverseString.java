package com.cyg.study.algorithm.leetcode;

import java.util.Arrays;

/**
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * <p>
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * <p>
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * <p>
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 *
 * @author cyg
 * @date 2021/6/17 15:40
 **/
public class LongestDiverseString {

    public static String longestDiverseString(int a, int b, int c) {
        int[][] cnt = new int[3][3];
        for (int i = 0; i < 3; i++) {
            cnt[i][0] = i;
        }
        cnt[0][1] = a;
        cnt[1][1] = b;
        cnt[2][1] = c;
        StringBuilder sb = new StringBuilder();

        while (true) {
            Arrays.sort(cnt, (o1, o2) -> {
                if (o2[2] == o1[2]) {
                    return o2[1] - o1[1];
                } else {
                    return o2[2] - o1[2];
                }
            });
            char ch = (char) (cnt[0][0] + 'a');
            if (cnt[0][1] >= 1) {
                if (cnt[0][1] < 2 || cnt[0][1] <= (cnt[1][1] + 1) / 2 || cnt[0][1] <= (cnt[2][1] + 1) / 2) {
                    cnt[0][1] -= 1;
                } else {
                    cnt[0][1] -= 2;
                    sb.append(ch);
                }
                sb.append(ch);
                cnt[2][2] = 0;
                cnt[0][2] = -1;
            } else {
                break;
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(2, 4, 1));
    }
}
