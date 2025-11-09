package com.java.patterns.trees;

public class TreeBTDiameter {

	private int max = 0;

	int diameter(TreeNode root) {
		max = 0;
		height(root);
		return max;
	}

	int height(TreeNode node) {
		if (node == null)
			return 0;
		int left = height(node.left);
		int right = height(node.right);

		max = Math.max(max, left + right);
		return Math.max(left, right) + 1;
	}

}
