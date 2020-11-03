package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 输入： [3,4,5,1,2]
 * 输出：1
 *
 * @author cyg
 * @date 2020/11/3 9:43
 **/
public class RotateTheSmallestNumberInTheArray {

    public int minNumberInRotateArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        RotateTheSmallestNumberInTheArray number = new RotateTheSmallestNumberInTheArray();
        int[] array = {3, 4, 5, 1, 2};
        System.out.println(number.minNumberInRotateArray(array));
    }
}
