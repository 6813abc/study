package com.cyg.study.algorithm.swordFingerOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个队列实现一个栈
 *
 * @author cyg
 * @date 2021/5/14 17:18
 **/
public class AQueueImplementsAStack {

    Queue<Integer> queue = new LinkedList<>();

    public void push(int node) {
        queue.offer(node);
    }

    public int pop() {
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.poll());
        }
        if (queue.peek() != null) {
            return queue.poll();
        }
        return -1;
    }

    public static void main(String[] args) {
        AQueueImplementsAStack stack = new AQueueImplementsAStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

}
