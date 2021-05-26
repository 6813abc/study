package com.cyg.study.algorithm.linklist;

import com.cyg.study.algorithm.swordFingerOffer.ListNode;
import org.elasticsearch.search.SearchHit;

/**
 * 删除链表中倒数第k个节点
 *
 * @author cyg
 * @date 2021/5/6 14:37
 **/
public class DeleteKNode {
    public static void main(String[] args) {
        /*String[] s = "1\\1\\1".split("\\\\");
        for (String s1 : s){
            System.out.println(s1);
        }*/
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(arr[0]);
        ListNode n = head;
        for (int i = 1; i < arr.length; i++) {
            n.next = new ListNode(arr[i]);
            n = n.next;
        }
        //删除前
        System.out.println("------删除前的链表：");
        System.out.println(toString(head));
        deleteNode(head, 3);
        //删除后
        System.out.println("------删除倒数第k个节点后的链表：");
        System.out.println(toString(head));
    }

    public static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode p = head;
        while (p != null) {
            sb.append(p.val).append(" ");
            p = p.next;
        }
        return sb.toString();
    }

    //利用双指针移动删除节点
    private static ListNode deleteNode(ListNode head, int n) {
        if (head.next == null || n < 0) return null;
        ListNode p = head;//开始指针
        ListNode p1 = head;//结束指针
        int count = 0;
        while (count < n && p.next != null) {//当所给定的n大于链表长度时，count<n成立，但是链表已经遍历到末尾
            p = p.next;
            count++;
        }
        System.out.println(p.val);
        if (count < n) return null;//直接返回null;
        while (p.next != null) {
            p = p.next;
            p1 = p1.next;
        }
        //找到了倒数第k个节点,将其删除
        p1.next = p1.next.next;
        return p1;//返回删除的节点的前一个节点
    }

}
