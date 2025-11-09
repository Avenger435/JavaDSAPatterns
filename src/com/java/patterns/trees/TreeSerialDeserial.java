package com.java.patterns.trees;

import java.util.Queue;

public class TreeSerialDeserial {

	String serialize(TreeNode root) {
		if (root == null)
			return "null,";
		return root.val + "," + serialize(root.left) + serialize(root.right);
	}

	TreeNode deserialize(Queue<String> nodes) {
		String val = nodes.poll();

		if (val.equals("null"))
			return null;
		TreeNode node = new TreeNode(Integer.parseInt(val));
		node.left = deserialize(nodes);
		node.right = deserialize(nodes);
		return node;

	}
}
