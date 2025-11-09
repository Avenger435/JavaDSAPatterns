package com.java.patterns.trees;

public class TreeDp {

	int[] rob(TreeNode root) {
		int[] left = rob(root.left);
		int[] right = rob(root.right);

		int rob = root.val + left[1] + right[1];
		int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return new int[] { rob, notRob };
	}

}
