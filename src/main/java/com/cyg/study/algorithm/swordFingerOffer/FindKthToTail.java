package com.cyg.study.algorithm.swordFingerOffer;

/**
 * 输入一个链表，输出一个链表，该输出链表包含原链表中从倒数第k个结点至尾节点的全部节点。
 * 如果该链表长度小于k，请返回一个长度为 0 的链表。
 *
 * @author cyg
 * @date 2021/6/15 10:08
 **/
public class FindKthToTail {
    public static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode findKthToTail(ListNode pHead, int k) {
        if (pHead == null || k == 0) {
            return null;
        }
        ListNode right = pHead;
        while (k > 1) {
            if (right.next != null) {
                right = right.next;
                k--;
            } else {
                return null;
            }
        }
        while (true) {
            if (right.next != null) {
                right = right.next;
                pHead = pHead.next;
            } else {
                return pHead;
            }
        }
    }
}
