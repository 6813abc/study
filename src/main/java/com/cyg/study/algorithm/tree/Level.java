package com.cyg.study.algorithm.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 层次遍历二叉树
 *
 * @author cyg
 * @date 2021/5/26 9:29
 **/
public class Level {

    private static List<Integer> notRecursion(Tree tree) {
        List<Integer> list = new ArrayList<>();
        Queue<Tree> queue = new ArrayDeque<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree cur = queue.poll();
            if (cur != null) {
                list.add(cur.getValue());
                if (cur.getLeft() != null) {
                    queue.add(cur.getLeft());
                }
                if (cur.getRight() != null) {
                    queue.add(cur.getRight());
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
        System.out.println(notRecursion(tree7));
    }
}
