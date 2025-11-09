package com.java.patterns.trees;

public class TreeBSTOperations {

	TreeNode search(TreeNode root, int val) {
		if (root == null || root.val == val)
			return root;
		return val < root.val ? search(root.left, val) : search(root.right, val);
	}

	TreeNode insert(TreeNode root, int val) {
		if (root == null)
			return new TreeNode(val);

		if (val < root.val)
			root.left = insert(root.left, val);
		else
			root.right = insert(root.right, val);
		return root;
	}
	
	

}
