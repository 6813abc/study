package com.cyg.study.algorithm.swordFingerOffer;

import java.util.*;

/**
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 输入：[[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcced"
 * 返回值：true
 * 输入：[[a,b,c,e],[s,f,c,s],[a,d,e,e]],"abcb"
 * 返回值：false
 *
 * @author cyg
 * @date 2021/6/16 10:02
 **/
public class HasPath {

    public boolean hasPath(char[][] matrix, String word) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (dfs(matrix, word.toCharArray(), i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] matrix, char[] word, int i, int j, int k) {
        if (i > matrix.length - 1 || i < 0 || j > matrix[0].length - 1 || j < 0
                || matrix[i][j] != word[k]) {
            return false;
        }
        if (k == word.length - 1) {
            return true;
        }
        //为了防止标记字符与矩阵原有字符重复，遍历后置空
        matrix[i][j] = '\0';
        boolean res = dfs(matrix, word, i + 1, j, k + 1)
                || dfs(matrix, word, i - 1, j, k + 1)
                || dfs(matrix, word, i, j + 1, k + 1)
                || dfs(matrix, word, i, j - 1, k + 1);
        //还原当前矩阵元素:将board[i][j]元素还原至初始值,即word[k]
        //递归之前置空了，现在要把它还原回去
        matrix[i][j] = word[k];
        //最终返回
        return res;
    }
}
