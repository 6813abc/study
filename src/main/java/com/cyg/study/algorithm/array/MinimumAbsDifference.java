package com.cyg.study.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你个整数数组 arr，其中每个元素都 不相同。请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。
 *
 * @author cyg
 * @date 2021/6/2 11:24
 **/
public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> re = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(arr[i]);
            list.add(arr[i + 1]);
            if (re.size() == 0) {
                re.add(list);
            } else {
                List<Integer> listLast = re.get(re.size() - 1);
                int sub = Math.abs(listLast.get(0) - listLast.get(1));
                int nowSub = Math.abs(arr[i] - arr[i + 1]);
                if (nowSub < sub) {
                    re.clear();
                    re.add(list);
                } else if (nowSub == sub) {
                    re.add(list);
                }
            }
        }
        return re;
    }
}
