package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * true
 *
 * @author cyg
 * @date 2020/10/29 19:16
 **/
public class OrderedTwoDimensionalArrayQuery {
    public boolean Find(int target, int[][] array) {
        int i = array.length - 1;
        int j = 0;
        while (j <= array[0].length - 1 && i >= 0) {
            int value = array[i][j];
            if (target == value) {
                return true;
            } else if (target > value) {
                j++;
            } else {
                i--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OrderedTwoDimensionalArrayQuery query = new OrderedTwoDimensionalArrayQuery();
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        //System.out.println(query.Find(7, array));
        //System.out.println(query.Find(1, array));
        System.out.println(query.Find(5, array));
    }
}
