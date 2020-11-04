package com.cyg.study.algorithm;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * [4,5,1,6,2,7,3,8],4 -> [1,2,3,4]
 *
 * @author cyg
 * @date 2020/11/4 15:45
 **/
public class GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (k == 0 || k > input.length) {
            return arrayList;
        }
        quickSort(input, 0, input.length - 1, k, arrayList);
        return arrayList;
    }

    public void quickSort(int[] input, int l, int r, int k, ArrayList<Integer> arrayList) {
        int i = l;
        int j = r;
        int temp = input[l];
        while (i < j) {
            while (i < j && input[j] >= temp) {
                j--;
            }
            if (i < j) {
                input[i++] = input[j];
            }
            while (i < j && input[i] <= temp) {
                i++;
            }
            if (i < j) {
                input[j--] = input[i];
            }
        }
        input[i] = temp;
        //得到下标左边的格式
        int num = i - l + 1;
        if (num == k) {
            for (int m = l; m <= i; m++) {
                arrayList.add(input[m]);
            }
        } else if (num < k) {
            for (int m = l; m <= i; m++) {
                arrayList.add(input[m]);
            }
            quickSort(input, i + 1, r, k - num, arrayList);
        } else {
            quickSort(input, l, i - 1, k, arrayList);
        }
    }

    public static void main(String[] args) {
        GetLeastNumbers getLeastNumbers = new GetLeastNumbers();
        int[] input = {4, 5, 1, 6, 2, 7, 3, 8};
        System.out.println(getLeastNumbers.GetLeastNumbers_Solution(input, 1));
    }
}
