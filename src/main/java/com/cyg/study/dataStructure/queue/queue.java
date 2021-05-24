package com.cyg.study.dataStructure.queue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author cyg
 * @date 2021/5/22 10:34
 **/
public class queue {

    public static void main(String[] args) {
        Queue<String> linkedList = new LinkedList<String>();//底层采用链表
        Queue<String> arrayDeque = new ArrayDeque<>();//底层采用循环数组
        arrayDeque.offer("1");
        arrayDeque.offer("2");
        arrayDeque.offer("3");
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.poll());
        System.out.println(arrayDeque.peek());
        int head = 3;
        int len = 16;
        System.out.println(head = (head - 1) & (len - 1));

        int tail = 5;
        System.out.println(tail = (tail + 1) & (len - 1));
    }
}
