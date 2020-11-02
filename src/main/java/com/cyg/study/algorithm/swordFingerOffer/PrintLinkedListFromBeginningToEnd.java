package com.cyg.study.algorithm.swordFingerOffer;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 输入：{67,0,24,58}
 * 输出：[58,24,0,67]
 *
 * @author cyg
 * @date 2020/11/2 16:01
 **/
public class PrintLinkedListFromBeginningToEnd {
    //利用list可以在指定位置插入值的特点
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (listNode != null) {
            arrayList.add(0, listNode.val);
            listNode = listNode.next;
        }
        return arrayList;
    }

    ArrayList<Integer> arrayList = new ArrayList<>();

    //递归添加
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead1(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(58);
        ListNode listNode3 = new ListNode(24);
        ListNode listNode2 = new ListNode(0);
        ListNode listNode1 = new ListNode(67);
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode1.next = listNode2;
        PrintLinkedListFromBeginningToEnd beginningToEnd = new PrintLinkedListFromBeginningToEnd();
        System.out.println(beginningToEnd.printListFromTailToHead(listNode1));
        System.out.println(beginningToEnd.printListFromTailToHead1(listNode1));
    }
}
