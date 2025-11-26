package com.java.patterns.leet;

import java.util.ArrayList;
import java.util.List;

public class MatrixTraversal {

    // Matrix Traversal Template
    // Traverses 2D array in spiral order
    public List<Integer> spiralTemplate(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;
            // Traverse down
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            // Traverse left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }

    // Sample Problem for Matrix Traversal: LeetCode 54. Spiral Matrix
    // Time Complexity: O(m * n), Space Complexity: O(1) excluding output
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralTemplate(matrix);
    }

    // Sample Problem for Matrix Traversal: LeetCode 73. Set Matrix Zeroes
    // Time Complexity: O(m * n), Space Complexity: O(1)
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        int m = matrix.length, n = matrix[0].length;
        // Check first row and column
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRowZero = true;
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstColZero = true;
        // Mark rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Set zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        // Set first row and column
        if (firstRowZero) for (int j = 0; j < n; j++) matrix[0][j] = 0;
        if (firstColZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }

    // Additional Matrix Traversal Templates

    // Row-wise Traversal Template
    // Traverses the matrix row by row, left to right
    public void rowWiseTraversal(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // Process matrix[i][j] here, e.g., System.out.print(matrix[i][j] + " ");
            }
        }
    }

    // Column-wise Traversal Template
    // Traverses the matrix column by column, top to bottom
    public void columnWiseTraversal(int[][] matrix) {
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                // Process matrix[i][j] here
            }
        }
    }

    // Diagonal Traversal Template (Main Diagonals)
    // Traverses from top-left to bottom-right diagonals
    public void diagonalTraversal(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        for (int d = 0; d < m + n - 1; d++) {
            for (int i = Math.max(0, d - n + 1); i <= Math.min(d, m - 1); i++) {
                int j = d - i;
                // Process matrix[i][j] here
            }
        }
    }

    // DFS Traversal Template for Matrix
    // Useful for connected components, islands, etc.
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // right, down, left, up

    public void dfsTraversal(int[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        // Process matrix[i][j] here, e.g., if it's an island cell

        for (int[] dir : directions) {
            dfsTraversal(matrix, i + dir[0], j + dir[1], visited);
        }
    }

    // BFS Traversal Template for Matrix
    // Useful for shortest paths, level-order traversals
    public void bfsTraversal(int[][] matrix, int startI, int startJ) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1];
            // Process matrix[i][j] here

            for (int[] dir : directions) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < matrix.length && nj >= 0 && nj < matrix[0].length && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    queue.add(new int[]{ni, nj});
                }
            }
        }
    }
}