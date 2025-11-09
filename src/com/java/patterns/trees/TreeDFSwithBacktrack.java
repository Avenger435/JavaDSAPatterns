package com.java.patterns.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeDFSwithBacktrack {

	void dfs(TreeNode node, List<Integer> path) {
		List<List<Integer>> result = new ArrayList<>();
		;
		if (node == null)
			return;

		path.add(node.val);

		if (node.left == null && node.right == null) {
			result.add(new ArrayList<>(path));
		} else {
			dfs(node.left, path);
			dfs(node.right, path);
		}
		path.remove(path.size() - 1); // backtrack
	}

}
