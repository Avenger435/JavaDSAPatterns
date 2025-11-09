package com.java.patterns.trees;

public class TreeMorrisTraversal {

	void morrisTraversal(TreeNode root) {
		TreeNode curr = root;

		while (curr != null) {
			if (curr.left == null) {
				visit(curr);
			} else {
				TreeNode pred = curr.left;
				while (pred.right != null && pred.right != curr) {
					pred = pred.right;
				}
				if (pred.right == null) {
					pred.right = curr;
					curr = curr.left;
				} else {
					pred.right = null;
					visit(curr);
					curr = curr.right;
				}
			}
		}
	}

	private void visit(TreeNode curr) {
		System.out.println(curr.val);
	}

}
