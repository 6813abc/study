package com.cyg.study.algorithm.leetcode;

import java.math.BigInteger;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * @author cyg
 * @date 2021/6/17 9:29
 **/
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigInteger sum = new BigInteger("0");
        BigInteger k1 = new BigInteger("1");
        BigInteger k2 = new BigInteger("1");
        while (l1 != null) {
            BigInteger val = new BigInteger(new BigInteger(l1.val + "").multiply(k1) + "");
            sum = sum.add(val);
            k1 = k1.multiply(new BigInteger(10 + ""));
            l1 = l1.next;
        }
        while (l2 != null) {
            BigInteger val = new BigInteger(new BigInteger(l2.val + "").multiply(k2) + "");
            sum = sum.add(val);
            k2 = k2.multiply(new BigInteger(10 + ""));
            l2 = l2.next;
        }
        ListNode root = new ListNode();
        String sumStr = sum + "";
        int len = sumStr.length();
        for (int i = 0; i < len; i++) {
            ListNode p = new ListNode();
            p.val = Integer.parseInt(sumStr.substring(i, i + 1));
            if (i != 0) {
                p.next = root;
            }
            root = p;
        }
        return root;
    }

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1, listNode1);
        ListNode listNode3 = new ListNode(1, listNode2);
        ListNode listNode4 = new ListNode(1, listNode3);
        ListNode listNode5 = new ListNode(1, listNode4);
        ListNode listNode6 = new ListNode(1, listNode5);
        ListNode listNode7 = new ListNode(1, listNode6);
        ListNode listNode8 = new ListNode(1, listNode7);
        ListNode listNode9 = new ListNode(1, listNode8);
        ListNode listNode10 = new ListNode(1, listNode9);
        ListNode listNode11x = new ListNode(1, listNode10);

        ListNode listNode11 = new ListNode(1);
        ListNode listNode22 = new ListNode(1, listNode11);
        ListNode listNode33 = new ListNode(1, listNode22);
        ListNode listNode44 = new ListNode(1, listNode33);
        ListNode listNode55 = new ListNode(1, listNode44);
        ListNode listNode66 = new ListNode(1, listNode55);
        ListNode listNode77 = new ListNode(1, listNode66);
        ListNode listNode88 = new ListNode(1, listNode77);
        ListNode listNode99 = new ListNode(1, listNode88);
        ListNode listNode101 = new ListNode(1, listNode99);
        ListNode listNode111 = new ListNode(1, listNode101);


        ListNode listNode1xx = addTwoNumbers(listNode11x, listNode111);
        while (listNode1xx != null) {
            System.out.println(listNode1xx.val);
            listNode1xx = listNode1xx.next;
        }
    }
}
