package com.java.patterns.datastructures;

import java.util.*;

/**
 * GraphPatterns class provides templates and sample problems for graph operations.
 * Includes DFS, BFS, topological sort, and shortest path.
 */
public class GraphPatterns {

    /**
     * Template: DFS (Depth-First Search).
     * Traverses the graph using recursion.
     * @param node the starting node
     * @param visited the visited array
     * @param graph the adjacency list
     */
    public void dfs(int node, boolean[] visited, List<Integer>[] graph) {
        visited[node] = true;
        // Process node
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, graph);
            }
        }
    }

    /**
     * Template: BFS (Breadth-First Search).
     * Traverses the graph using a queue.
     * @param start the starting node
     * @param graph the adjacency list
     */
    public void bfs(int start, List<Integer>[] graph) {
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
     * Template: Topological Sort using Kahn's algorithm.
     * Sorts nodes in topological order.
     * @param numCourses the number of nodes
     * @param prerequisites the edges
     * @return the topological order
     */
    public int[] topologicalSort(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] prereq : prerequisites) {
            graph[prereq[1]].add(prereq[0]);
            indegree[prereq[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }
        int[] result = new int[numCourses];
        int index = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[index++] = node;
            for (int neighbor : graph[node]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        return index == numCourses ? result : new int[0]; // If cycle, return empty
    }

    /**
     * Sample: LeetCode 200. Number of Islands
     * Time: O(m * n), Space: O(m * n)
     * Counts the number of islands in a grid.
     * @param grid the 2D grid
     * @return the number of islands
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfsIsland(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfsIsland(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0'; // Mark as visited
        dfsIsland(grid, i + 1, j);
        dfsIsland(grid, i - 1, j);
        dfsIsland(grid, i, j + 1);
        dfsIsland(grid, i, j - 1);
    }

    /**
     * Sample: LeetCode 207. Course Schedule
     * Time: O(V + E), Space: O(V + E)
     * Checks if it's possible to finish all courses.
     * @param numCourses the number of courses
     * @param prerequisites the prerequisites
     * @return true if possible, false otherwise
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] result = topologicalSort(numCourses, prerequisites);
        return result.length == numCourses;
    }

    /**
     * Sample: LeetCode 743. Network Delay Time
     * Time: O((V + E) log V), Space: O(V + E)
     * Finds the time for all nodes to receive the signal using Dijkstra.
     * @param times the edges with weights
     * @param n the number of nodes
     * @param k the starting node
     * @return the maximum delay time
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] time : times) {
            graph[time[0]].add(new int[]{time[1], time[2]});
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // {node, dist}
        pq.offer(new int[]{k, 0});
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];
            if (time > dist[node]) continue;
            for (int[] neighbor : graph[node]) {
                int nei = neighbor[0], w = neighbor[1];
                if (dist[nei] > time + w) {
                    dist[nei] = time + w;
                    pq.offer(new int[]{nei, dist[nei]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        return max;
    }
}