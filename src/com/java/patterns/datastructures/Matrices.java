package com.java.patterns.datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Matrices class provides templates and sample problems for matrix operations.
 * Includes traversal, rotation, and in-place modifications.
 */
public class Matrices {

    /**
     * Template: Spiral Traversal of a matrix.
     * Traverses the matrix in spiral order.
     * @param matrix the 2D matrix
     * @return list of elements in spiral order
     */
    public List<Integer> spiralTraversalTemplate(int[][] matrix) {
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

    /**
     * Template: Rotate matrix 90 degrees clockwise in-place.
     * Rotates the matrix by transposing and reversing rows.
     * @param matrix the 2D matrix
     */
    public void rotateMatrixTemplate(int[][] matrix) {
        int n = matrix.length;
        // Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

    /**
     * Template: Set matrix zeroes in-place.
     * Uses first row and column as markers.
     * @param matrix the 2D matrix
     */
    public void setZeroesTemplate(int[][] matrix) {
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

    /**
     * Sample: LeetCode 54. Spiral Matrix
     * Time: O(m * n), Space: O(1) excluding output
     * Returns all elements of the matrix in spiral order.
     * @param matrix the 2D matrix
     * @return list of elements in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralTraversalTemplate(matrix);
    }

    /**
     * Sample: LeetCode 48. Rotate Image
     * Time: O(n^2), Space: O(1)
     * Rotates the image 90 degrees clockwise in-place.
     * @param matrix the n x n matrix
     */
    public void rotate(int[][] matrix) {
        rotateMatrixTemplate(matrix);
    }

    /**
     * Sample: LeetCode 73. Set Matrix Zeroes
     * Time: O(m * n), Space: O(1)
     * Sets entire row and column to 0 if an element is 0.
     * @param matrix the 2D matrix
     */
    public void setZeroes(int[][] matrix) {
        setZeroesTemplate(matrix);
    }

    /**
     * Sample: LeetCode 74. Search a 2D Matrix
     * Time: O(m + n), Space: O(1)
     * Searches for a target in a sorted matrix using one-pass approach.
     * @param matrix the sorted 2D matrix
     * @param target the value to search
     * @return true if found, false otherwise
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1; // Start from top-right
        while (row < m && col >= 0) {
            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] > target) col--; // Move left
            else row++; // Move down
        }
        return false;
    }
}