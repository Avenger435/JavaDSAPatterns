package com.java.patterns.trees;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruct {

	TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inMap= new HashMap<>();
		for(int i=0;i< inorder.length;i++) {
			inMap.put(inorder[i],i);
		}
		return build(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
	}

	private TreeNode build(int[] preorder, int i, int j, int[] inorder, int k, int l) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
