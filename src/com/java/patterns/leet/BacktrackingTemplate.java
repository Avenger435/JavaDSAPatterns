package com.java.patterns.leet;

import java.util.ArrayList;
import java.util.List;

public class BacktrackingTemplate {

    /**
     * Backtracking is a general algorithm for finding all (or some) solutions to computational problems,
     * particularly constraint satisfaction problems. It incrementally builds candidates to the solutions,
     * and abandons a candidate ("backtracks") as soon as it determines that the candidate cannot possibly
     * be completed to a valid solution.
     *
     * The basic template for backtracking:
     * - Define the problem state (e.g., current path, used elements).
     * - Define the base case (when to stop and record a solution).
     * - Iterate over choices.
     * - Make a choice, recurse, then backtrack (undo the choice).
     */

    // Generic Backtracking Template
    public void backtrack(List<Object> current, List<Object> choices, List<List<Object>> result) {
        // Base case: if current is a valid solution, add to result
        if (isSolution(current)) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate over choices
        for (Object choice : choices) {
            if (isValid(choice, current)) {
                // Make choice
                current.add(choice);
                // Recurse
                backtrack(current, choices, result);
                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    // Placeholder methods - to be overridden for specific problems
    private boolean isSolution(List<Object> current) {
        return false; // Implement based on problem
    }

    private boolean isValid(Object choice, List<Object> current) {
        return true; // Implement based on problem
    }

    // Example 1: Generate all subsets of a set
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrackSubsets(new ArrayList<>(), nums, 0, result);
        return result;
    }

    private void backtrackSubsets(List<Integer> current, int[] nums, int start, List<List<Integer>> result) {
        // Add current subset to result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include nums[i]
            current.add(nums[i]);
            // Recurse with next index
            backtrackSubsets(current, nums, i + 1, result);
            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    // Example 2: Generate all permutations of a list
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrackPermute(current, nums, used, result);
        return result;
    }

    private void backtrackPermute(List<Integer> current, int[] nums, boolean[] used, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(nums[i]);
                backtrackPermute(current, nums, used, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    // Example 3: N-Queens problem - simplified to count solutions
    public int totalNQueens(int n) {
        int[] queens = new int[n]; // queens[i] = column for row i
        return backtrackNQueens(queens, 0, n);
    }

    private int backtrackNQueens(int[] queens, int row, int n) {
        if (row == n) {
            return 1; // Found a solution
        }

        int count = 0;
        for (int col = 0; col < n; col++) {
            if (isValidQueen(queens, row, col)) {
                queens[row] = col;
                count += backtrackNQueens(queens, row + 1, n);
                // No need to backtrack explicitly since we're overwriting
            }
        }
        return count;
    }

    private boolean isValidQueen(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || Math.abs(queens[i] - col) == row - i) {
                return false;
            }
        }
        return true;
    }
}