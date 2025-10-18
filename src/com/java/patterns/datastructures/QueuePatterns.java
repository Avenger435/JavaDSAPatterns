package com.java.patterns.datastructures;

import java.util.LinkedList;
import java.util.Queue;

/**
 * QueuePatterns class provides templates and sample problems for queue-based operations.
 * Includes BFS and sliding window maximum patterns.
 */
public class QueuePatterns {

    /**
     * Template: Basic queue operations.
     * Demonstrates enqueue, dequeue, and peek.
     */
    public void basicQueueOperations() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // Enqueue
        int front = queue.peek(); // Get front without removing
        int dequeued = queue.poll(); // Dequeue
    }

    /**
     * Template: BFS using queue.
     * Performs breadth-first search on a graph or tree.
     * @param graph the adjacency list
     * @param start the starting node
     */
    public void bfsTemplate(int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            // Process node
            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    /**
     * Sample: LeetCode 102. Binary Tree Level Order Traversal
     * Time: O(n), Space: O(n)
     * Performs level order traversal of a binary tree.
     * @param root the root of the binary tree
     * @return list of lists for each level
     */
    public java.util.List<java.util.List<Integer>> levelOrder(TreeNode root) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            java.util.List<Integer> level = new java.util.ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    /**
     * Sample: LeetCode 239. Sliding Window Maximum
     * Time: O(n), Space: O(k)
     * Finds the maximum in each sliding window of size k.
     * @param nums the input array
     * @param k the window size
     * @return array of maximums
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        java.util.Deque<Integer> deque = new java.util.LinkedList<>(); // Deque for indices
        for (int i = 0; i < nums.length; i++) {
            // Remove elements out of window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Remove smaller elements
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            // Add to result when window is full
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    // TreeNode class for samples
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }
}