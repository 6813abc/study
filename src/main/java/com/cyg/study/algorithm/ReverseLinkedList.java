package com.cyg.study.algorithm;

import com.cyg.study.algorithm.swordFingerOffer.ListNode;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author cyg
 * @date 2020/11/3 11:12
 **/
public class ReverseLinkedList {


    public ListNode ReverseList(ListNode head) {
        ListNode newHead = null;
        ListNode pNode = head;
        ListNode pPrev = null;
        while (pNode != null) {
            ListNode next = pNode.next;
            if (next == null) {
                newHead = pNode;
            }
            pNode.next = pPrev;
            pPrev = pNode;
            pNode = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList list = new ReverseLinkedList();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        listNode1.next = listNode2;
        ListNode listNode = list.ReverseList(listNode1);
        System.out.println(listNode.val);
        System.out.println(listNode.next.val);
        System.out.println(listNode.next.next.val);
    }
}
