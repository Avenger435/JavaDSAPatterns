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
}