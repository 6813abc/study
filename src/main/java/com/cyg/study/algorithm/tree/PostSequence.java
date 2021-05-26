package com.cyg.study.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树后序
 *
 * @author cyg
 * @date 2021/5/25 20:39
 **/
public class PostSequence {

    /**
     * 递归
     **/
    private static List<Integer> recursion(Tree tree, List<Integer> list) {
        if (tree != null) {
            list = recursion(tree.getLeft(), list);
            list = recursion(tree.getRight(), list);
            list.add(tree.getValue());
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
        Tree pre = p;
        while (p != null || !stack.isEmpty()) {
            //1.将根节点及其左孩子入栈
            while (p != null) {
                stack.push(p);
                p = p.getLeft();
            }
            if (!stack.empty()) {
                //2.获取栈顶元素值
                p = stack.peek();
                //3.没有右孩子，或者右孩子已经被访问过
                if (p.getRight() == null || p.getRight() == pre) {
                    //则可以访问栈顶元素
                    p = stack.pop();
                    list.add(p.getValue());
                    //标记上一次访问的节点
                    pre = p;
                    p = null;
                }
                //4.存在没有被访问的右孩子
                else {
                    p = p.getRight();
                }
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
