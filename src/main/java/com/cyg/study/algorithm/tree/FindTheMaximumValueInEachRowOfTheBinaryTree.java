package com.cyg.study.algorithm.tree;


import com.cyg.study.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**二叉树每层最大值
 * @author cyg
 * @date 2020/8/31 10:00
 **/
public class FindTheMaximumValueInEachRowOfTheBinaryTree {


    public List<Integer> helper(TreeNode root) {
        //LinkedList实现队列
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> values = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            //每一层的数量
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                //出队
                TreeNode node = queue.poll();
                //记录每层的最大值
                if (node != null) {
                    max = Math.max(max, node.getVal());
                    if (node.getLeft() != null) {
                        queue.add(node.getLeft());
                    }
                    if (node.getRight() != null) {
                        queue.add(node.getRight());
                    }
                }
            }
            values.add(max);
        }
        return values;
    }

    public static void main(String[] args) {
        FindTheMaximumValueInEachRowOfTheBinaryTree value = new FindTheMaximumValueInEachRowOfTheBinaryTree();
        TreeNode treeNodeLeft = new TreeNode(2, new TreeNode(0, null, null), new TreeNode(8, null, null));
        TreeNode treeNodeRight = new TreeNode(5, new TreeNode(7, null, null), new TreeNode(9, null, null));
        TreeNode root = new TreeNode(1, treeNodeLeft, treeNodeRight);
        List<Integer> integers = value.helper(root);
        System.out.println(integers);
    }
}
