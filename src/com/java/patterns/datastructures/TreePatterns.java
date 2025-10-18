package com.java.patterns.datastructures;

/**
 * TreePatterns class provides templates and sample problems for tree operations.
 * Includes traversal methods and BST validations.
 */
public class TreePatterns {

    /**
     * TreeNode class for binary tree.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    /**
     * Template: Inorder Traversal (recursive).
     * Visits left, root, right.
     * @param root the root of the tree
     * @param result the list to store traversal
     */
    public void inorderTraversal(TreeNode root, java.util.List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result); // Left
        result.add(root.val); // Root
        inorderTraversal(root.right, result); // Right
    }

    /**
     * Template: Preorder Traversal (recursive).
     * Visits root, left, right.
     * @param root the root of the tree
     * @param result the list to store traversal
     */
    public void preorderTraversal(TreeNode root, java.util.List<Integer> result) {
        if (root == null) return;
        result.add(root.val); // Root
        preorderTraversal(root.left, result); // Left
        preorderTraversal(root.right, result); // Right
    }

    /**
     * Template: Postorder Traversal (recursive).
     * Visits left, right, root.
     * @param root the root of the tree
     * @param result the list to store traversal
     */
    public void postorderTraversal(TreeNode root, java.util.List<Integer> result) {
        if (root == null) return;
        postorderTraversal(root.left, result); // Left
        postorderTraversal(root.right, result); // Right
        result.add(root.val); // Root
    }

    /**
     * Template: Level Order Traversal (iterative using queue).
     * Visits nodes level by level.
     * @param root the root of the tree
     * @return list of lists for each level
     */
    public java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            java.util.List<Integer> level = new java.util.ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    /**
     * Sample: LeetCode 226. Invert Binary Tree
     * Time: O(n), Space: O(h) where h is height
     * Inverts the binary tree.
     * @param root the root of the tree
     * @return the inverted tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    /**
     * Sample: LeetCode 98. Validate Binary Search Tree
     * Time: O(n), Space: O(h)
     * Checks if the tree is a valid BST.
     * @param root the root of the tree
     * @return true if valid BST, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTHelper(TreeNode node, long min, long max) {
        if (node == null) return true;
        if (node.val <= min || node.val >= max) return false;
        return isValidBSTHelper(node.left, min, node.val) && isValidBSTHelper(node.right, node.val, max);
    }

    /**
     * Sample: LeetCode 236. Lowest Common Ancestor of a Binary Tree
     * Time: O(n), Space: O(h)
     * Finds the LCA of two nodes.
     * @param root the root of the tree
     * @param p the first node
     * @param q the second node
     * @return the LCA node
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}