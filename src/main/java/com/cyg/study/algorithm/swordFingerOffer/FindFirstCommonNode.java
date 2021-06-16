package com.cyg.study.algorithm.swordFingerOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入两个无环的单链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * @author cyg
 * @date 2021/6/16 11:16
 **/
public class FindFirstCommonNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        List<ListNode> listNodes1 = new ArrayList<>();
        List<ListNode> listNodes2 = new ArrayList<>();
        while (pHead1 != null) {
            listNodes1.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            listNodes2.add(pHead2);
            pHead2 = pHead2.next;
        }
        int i = listNodes1.size() - 1;
        int j = listNodes2.size() - 1;
        while (i >= 0 && j >= 0 && listNodes1.get(i).val == listNodes2.get(j).val) {
            i--;
            j--;
        }
        i++;
        if (i < 0 || i > (listNodes1.size() - 1)) {
            return null;
        }
        return listNodes1.get(i);
    }
}
