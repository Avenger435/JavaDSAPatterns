package com.java.patterns.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 */
public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {

	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}

	public static TreeNode createTreeFromArray(Integer[] arr) {
		if (arr == null || arr.length == 0 || arr[0] == null)
			return null;
		TreeNode root = new TreeNode(arr[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		int i = 1;
		while (i < arr.length) {
			TreeNode current = queue.poll();
			// left child;
			if (i < arr.length && arr[i] != null) {
				current.left = new TreeNode(arr[i]);
				queue.offer(current.left);
			}
			i++;
			// right child
			if (i < arr.length && arr[i] != null) {
				current.right = new TreeNode(arr[i]);
				queue.offer(current.right);
			}
			i++;
		}

		return root;
	}

	// in-order left center right - LCR
	public static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	// pre-order center left right - CLR
	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	// pre-order left right center - LRC
	public static void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	public static void printTree(TreeNode root, String indent, boolean isLeft) {
		if (root == null)
			return;

		printTree(root.right, indent + (isLeft ? "│   " : "    "), false);
		System.out.println(indent + (isLeft ? "└── " : "┌── ") + root.val);
		printTree(root.left, indent + (isLeft ? "    " : "│   "), true);
	}

	/**
	 * Builds a binary tree from a level-order array representation. Example:
	 * [3,9,20,null,null,15,7]
	 * 
	 * @param arr Integer array (null for missing nodes)
	 * @return root TreeNode
	 */
	public static TreeNode buildTreeFromArray(Integer[] arr) {
		if (arr == null || arr.length == 0 || arr[0] == null)
			return null;
		TreeNode root = new TreeNode(arr[0]);
		java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
		queue.offer(root);
		int i = 1;
		while (!queue.isEmpty() && i < arr.length) {
			TreeNode current = queue.poll();
			if (i < arr.length && arr[i] != null) {
				current.left = new TreeNode(arr[i]);
				queue.offer(current.left);
			}
			i++;
			if (i < arr.length && arr[i] != null) {
				current.right = new TreeNode(arr[i]);
				queue.offer(current.right);
			}
			i++;
		}
		return root;
	}
	
}