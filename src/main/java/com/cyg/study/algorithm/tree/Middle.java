package com.cyg.study.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序
 *
 * @author cyg
 * @date 2021/5/25 20:39
 **/
public class Middle {

    /**
     * 递归
     **/
    private static List<Integer> recursion(Tree tree, List<Integer> list) {
        if (tree != null) {
            list = recursion(tree.getLeft(), list);
            list.add(tree.getValue());
            list = recursion(tree.getRight(), list);
        }
        return list;
    }

    /**
     * 非递归，借助栈
     */
    private static List<Integer> notRecursion(Tree tree) {
        List<Integer> list = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        Tree p = tree;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            p = stack.pop();
            list.add(p.getValue());
            p = p.getRight();
        }
        return list;
    }

    public static void main(String[] args) {
        Tree tree0 = new Tree(0, null, null);
        Tree tree1 = new Tree(1, tree0, null);
        Tree tree2 = new Tree(2, null, null);
        Tree tree3 = new Tree(3, null, null);
        Tree tree4 = new Tree(4, null, null);
        Tree tree5 = new Tree(5, tree1, tree2);
        Tree tree6 = new Tree(6, tree3, tree4);
        Tree tree7 = new Tree(7, tree5, tree6);
        List<Integer> list = new ArrayList<>();
        System.out.println(recursion(tree7, list));
        System.out.println(notRecursion(tree7));
    }
}
