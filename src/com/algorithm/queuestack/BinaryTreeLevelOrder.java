package com.algorithm.queuestack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
    public static void main(String[] args) {
        BinaryTreeLevelOrder binaryTreeLevelOrder = new BinaryTreeLevelOrder();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(binaryTreeLevelOrder.solve(root));
    }

    public List<List<Integer>> solve(TreeNode tree) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(tree);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int x) {
        this.val = x;
    }
}
