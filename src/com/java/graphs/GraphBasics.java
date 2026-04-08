package com.java.graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class GraphBasics {

	public boolean validTree(int n, int[][] edges) {
		// Quick guard: empty graph isn't considered a tree here
		if (n == 0)
			return false;

		if (edges == null)
			edges = new int[0][];

		// For an undirected graph to be a tree it must have exactly n-1 edges
		if (edges.length != n - 1) {
			return false;
		}

		// 1. Initialize the adjacent List
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}

		// 2. fill the list with edges.
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

			// for undirected graphs: add both ways
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		// BFS to check connectivity

		Set<Integer> visited = new HashSet<>();
		Queue<Integer> queue = new LinkedList<>();

		queue.add(0);
		visited.add(0);

		while (!queue.isEmpty()) {
			int curr = queue.poll();
			for (int neighbor : adj.get(curr)) {
				if (!visited.contains(neighbor)) {
					visited.add(neighbor);
					queue.add(neighbor);
				}
			}
		}

		return visited.size() == n;
	}

	public static void main(String[] args) {
		GraphBasics gb = new GraphBasics();

		// Sample 1: valid tree
		int n1 = 5;
		int[][] edges1 = { {0,1}, {0,2}, {0,3}, {3,4} };
		System.out.println("Sample 1 - valid tree expected=true -> actual=" + gb.validTree(n1, edges1));

		// Sample 2: cycle present
		int n2 = 3;
		int[][] edges2 = { {0,1}, {1,2}, {2,0} }; // has a cycle
		System.out.println("Sample 2 - cycle expected=false -> actual=" + gb.validTree(n2, edges2));

		// Sample 3: disconnected
		int n3 = 4;
		int[][] edges3 = { {0,1}, {2,3} }; // disconnected components
		System.out.println("Sample 3 - disconnected expected=false -> actual=" + gb.validTree(n3, edges3));

		// Sample 4: single node
		int n4 = 1;
		int[][] edges4 = { };
		System.out.println("Sample 4 - single node expected=true -> actual=" + gb.validTree(n4, edges4));

		// Sample 5: null edges treated as empty
		int n5 = 1;
		int[][] edges5 = null;
		System.out.println("Sample 5 - null edges expected=true -> actual=" + gb.validTree(n5, edges5));
	}

}