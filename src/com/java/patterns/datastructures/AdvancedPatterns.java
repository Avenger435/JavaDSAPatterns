package com.java.patterns.datastructures;

import java.util.*;

/**
 * AdvancedPatterns class provides templates and sample problems for advanced data structures.
 * Includes Union-Find, Trie, Segment Tree, and Fenwick Tree.
 */
public class AdvancedPatterns {

    /**
     * Template: Union-Find (Disjoint Set Union).
     * Supports find and union operations.
     */
    static class UnionFind {
        int[] parent;
        int[] rank;

        UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int x, int y) {
            int px = find(x), py = find(y);
            if (px == py) return false;
            if (rank[px] < rank[py]) parent[px] = py;
            else if (rank[px] > rank[py]) parent[py] = px;
            else {
                parent[py] = px;
                rank[px]++;
            }
            return true;
        }
    }

    /**
     * Template: Trie (Prefix Tree).
     * Supports insert and search operations.
     */
    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isEnd = true;
        }

        boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return node.isEnd;
        }

        boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) return false;
                node = node.children[c - 'a'];
            }
            return true;
        }
    }

    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    /**
     * Template: Segment Tree for range queries.
     * Supports build, update, and query operations.
     */
    static class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int[] arr) {
            n = arr.length;
            tree = new int[4 * n];
            build(arr, 0, 0, n - 1);
        }

        void build(int[] arr, int node, int start, int end) {
            if (start == end) {
                tree[node] = arr[start];
                return;
            }
            int mid = (start + end) / 2;
            build(arr, 2 * node + 1, start, mid);
            build(arr, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }

        void update(int idx, int val, int node, int start, int end) {
            if (start == end) {
                tree[node] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (idx <= mid) update(idx, val, 2 * node + 1, start, mid);
            else update(idx, val, 2 * node + 2, mid + 1, end);
            tree[node] = tree[2 * node + 1] + tree[2 * node + 2];
        }

        int query(int left, int right, int node, int start, int end) {
            if (right < start || left > end) return 0;
            if (left <= start && end <= right) return tree[node];
            int mid = (start + end) / 2;
            return query(left, right, 2 * node + 1, start, mid) + query(left, right, 2 * node + 2, mid + 1, end);
        }
    }

    /**
     * Sample: LeetCode 684. Redundant Connection
     * Time: O(n), Space: O(n)
     * Finds the redundant connection in a graph using Union-Find.
     * @param edges the edges
     * @return the redundant edge
     */
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        UnionFind uf = new UnionFind(n + 1);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[0];
    }

    /**
     * Sample: LeetCode 212. Word Search II
     * Time: O(m * n * 4^k), Space: O(n * m + sum of words)
     * Finds all words in the board using Trie and DFS.
     * @param board the 2D board
     * @param words the list of words
     * @return the list of found words
     */
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) trie.insert(word);
        Set<String> result = new HashSet<>();
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, "", result);
            }
        }
        return new ArrayList<>(result);
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, String word, Set<String> result) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || node.children[board[i][j] - 'a'] == null) return;
        visited[i][j] = true;
        node = node.children[board[i][j] - 'a'];
        word += board[i][j];
        if (node.isEnd) result.add(word);
        dfs(board, visited, i + 1, j, node, word, result);
        dfs(board, visited, i - 1, j, node, word, result);
        dfs(board, visited, i, j + 1, node, word, result);
        dfs(board, visited, i, j - 1, node, word, result);
        visited[i][j] = false;
    }

    /**
     * Sample: LeetCode 303. Range Sum Query - Immutable
     * Time: Build O(n), Query O(1), Space: O(n)
     * Supports range sum queries using prefix sum.
     */
    static class NumArray {
        int[] prefix;

        NumArray(int[] nums) {
            prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }
}