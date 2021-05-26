package com.cyg.study.algorithm.linklist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 合并有序链表
 *
 * @author cyg
 * @date 2021/5/20 11:34o
 **/
public class MergeLinkedList {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class ListNode {
        private int val;
        private ListNode next;
    }

    private static ListNode mergeLinkedList(ListNode l1, ListNode l2) {
        ListNode mergeLinkedList = new ListNode();
        ListNode p = mergeLinkedList;
        while (l1 != null && l2 != null) {
            ListNode linkedList = new ListNode();
            if (l1.getVal() < l2.getVal()) {
                linkedList.setVal(l1.getVal());
                l1 = l1.getNext();
            } else {
                linkedList.setVal(l2.getVal());
                l2 = l2.getNext();
            }
            p.setNext(linkedList);
            p = linkedList;
            if (l1 == null) {
                p.setNext(l2);
            }
            if (l2 == null) {
                p.setNext(l1);
            }
        }
        return mergeLinkedList.getNext();
    }

    public static void main(String[] args) {
        ListNode linkedList1 = new ListNode(9, null);
        ListNode linkedList2 = new ListNode(6, linkedList1);
        ListNode linkedList3 = new ListNode(1, linkedList2);

        ListNode linkedList4 = new ListNode(11, null);
        ListNode linkedList5 = new ListNode(7, linkedList4);
        ListNode linkedList6 = new ListNode(2, linkedList5);

        ListNode linkedList = mergeLinkedList(linkedList3, linkedList6);
        while (linkedList != null) {
            System.out.println(linkedList.getVal());
            linkedList = linkedList.getNext();
        }
    }
}
