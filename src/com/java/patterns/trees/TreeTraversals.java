package com.java.patterns.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {

	void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root);
		inorder(root.right);
	}

	void preorder(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root);
		preorder(root.left);
		preorder(root.right);
	}

	void postorder(TreeNode root) {
		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root);
	}

	void levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.println(node);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

}
