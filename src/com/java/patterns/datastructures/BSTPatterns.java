package com.java.patterns.datastructures;

/**
 * BSTPatterns class provides templates and sample problems for binary search tree operations.
 * Includes insertion, deletion, search, and inorder traversal.
 */
public class BSTPatterns {

    /**
     * TreeNode class for BST.
     */
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    /**
     * Template: Search in BST.
     * Searches for a value in the BST.
     * @param root the root of the BST
     * @param val the value to search
     * @return the node if found, null otherwise
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        if (val < root.val) return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    /**
     * Template: Insert into BST.
     * Inserts a value into the BST.
     * @param root the root of the BST
     * @param val the value to insert
     * @return the root of the BST
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * Template: Delete from BST.
     * Deletes a value from the BST.
     * @param root the root of the BST
     * @param key the value to delete
     * @return the root of the BST
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            // Node to delete found
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            // Find inorder successor
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) node = node.left;
        return node;
    }

    /**
     * Sample: LeetCode 701. Insert into a Binary Search Tree
     * Time: O(h), Space: O(h)
     * Inserts a value into the BST.
     * @param root the root of the BST
     * @param val the value to insert
     * @return the root of the BST
     */
    public TreeNode insertIntoBSTSample(TreeNode root, int val) {
        return insertIntoBST(root, val);
    }

    /**
     * Sample: LeetCode 450. Delete Node in a BST
     * Time: O(h), Space: O(h)
     * Deletes a node from the BST.
     * @param root the root of the BST
     * @param key the value to delete
     * @return the root of the BST
     */
    public TreeNode deleteNodeSample(TreeNode root, int key) {
        return deleteNode(root, key);
    }

    /**
     * Sample: LeetCode 230. Kth Smallest Element in a BST
     * Time: O(h + k), Space: O(h)
     * Finds the kth smallest element using inorder traversal.
     * @param root the root of the BST
     * @param k the kth position
     * @return the kth smallest value
     */
    public int kthSmallest(TreeNode root, int k) {
        java.util.List<Integer> inorder = new java.util.ArrayList<>();
        inorderTraversal(root, inorder);
        return inorder.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, java.util.List<Integer> result) {
        if (root == null) return;
        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}