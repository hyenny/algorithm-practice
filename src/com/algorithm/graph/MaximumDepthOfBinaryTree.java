package com.algorithm.graph;

public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        System.out.println(maximumDepthOfBinaryTree.solve(tree));
    }

    public int solve(TreeNode tree) {
        return maxDepth(tree);
    }

    // 재귀
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;

        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        return Math.max(leftMax, rightMax) + 1;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        this.val = x;
    }
}