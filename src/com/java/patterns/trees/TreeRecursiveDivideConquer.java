package com.java.patterns.trees;

public class TreeRecursiveDivideConquer {

	int helper(TreeNode node) {
		if (node == null)
			return 0;
		int left = helper(node.left);
		int right = helper(node.right);
		return Math.max(left, right) + 1;
	}

}
