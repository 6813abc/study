package com.cyg.study.algorithm.linklist;

import com.cyg.study.algorithm.swordFingerOffer.ListNode;

/**
 * 判断给定的链表中是否有环
 * 扩展：
 * 你能给出空间复杂度o(1)的解法么？
 *
 * @author cyg
 * @date 2020/11/3 14:58
 **/
public class HasCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
