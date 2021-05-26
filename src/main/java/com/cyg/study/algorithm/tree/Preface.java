package com.cyg.study.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树先序
 *
 * @author cyg
 * @date 2021/5/25 20:39
 **/
public class Preface {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Tree {
        private Integer value;
        private Tree leftTree;
        private Tree rightTree;
    }

    /**
     * 递归
     **/
    private static List<Integer> recursion(Tree tree, List<Integer> list) {
        if (tree != null) {
            list.add(tree.getValue());
            list = recursion(tree.getLeftTree(), list);
            list = recursion(tree.getRightTree(), list);
        }
        return list;
    }

    /**
     * 非递归，借助栈
     */
    private static List<Integer> notRecursion(Tree tree) {
        List<Integer> list = new ArrayList<>();
        Stack<Tree> stack = new Stack<>();
        stack.push(tree);
        while (!stack.isEmpty()) {
            Tree current = stack.pop();
            list.add(current.getValue());
            if (current.getRightTree() != null) {
                stack.push(current.getRightTree());
            }
            if (current.getLeftTree() != null) {
                stack.push(current.getLeftTree());
            }
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
