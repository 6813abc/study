package com.cyg.study.algorithm.array;

/**
 * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
 * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
 * [1,3,5,2,2],5,3 -> 2
 *
 * @author cyg
 * @date 2020/11/4 11:32
 **/
public class FindKth {

    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    public int quickSort(int[] a, int l, int r, int k) {
        int x = a[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (i < j && a[j] >= x) {
                j--;
            }
            if (i < j) {
                a[i++] = a[j];
            }
            while (i < j && a[i] <= x) {
                i++;
            }
            if (i < j) {
                a[j--] = a[i];
            }
        }
        a[i] = x;
        int bigNum = r - i;
        if (k - bigNum - 1 == 0) {
            return x;
        } else if (k - bigNum - 1 > 0) {
            return quickSort(a, l, i - 1, k - bigNum - 1);
        } else {
            return quickSort(a, i + 1, r, k);
        }
    }

    public static void main(String[] args) {
        FindKth findKth = new FindKth();
        int[] a = {1, 3, 5, 2, 2};
        System.out.println(findKth.findKth(a, 5, 4));
    }
}
