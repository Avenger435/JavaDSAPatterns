package com.java.patterns.datastructures;

/**
 * DPPatterns class provides templates and sample problems for dynamic programming.
 * Includes 1D/2D DP, knapsack, and longest common subsequence.
 */
public class DPPatterns {

    /**
     * Template: 1D DP for climbing stairs.
     * dp[i] represents the number of ways to reach step i.
     * @param n the number of steps
     * @return the number of ways
     */
    public int climbingStairsTemplate(int n) {
        if (n <= 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * Template: 2D DP for longest common subsequence.
     * dp[i][j] represents LCS of first i and first j characters.
     * @param text1 the first string
     * @param text2 the second string
     * @return the length of LCS
     */
    public int lcsTemplate(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * Template: Knapsack DP.
     * dp[i][w] represents max value with first i items and weight w.
     * @param weights the weights
     * @param values the values
     * @param W the max weight
     * @return the max value
     */
    public int knapsackTemplate(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        return dp[n][W];
    }

    /**
     * Sample: LeetCode 70. Climbing Stairs
     * Time: O(n), Space: O(n)
     * Calculates the number of ways to climb n stairs.
     * @param n the number of stairs
     * @return the number of ways
     */
    public int climbStairs(int n) {
        return climbingStairsTemplate(n);
    }

    /**
     * Sample: LeetCode 322. Coin Change
     * Time: O(amount * coins), Space: O(amount)
     * Finds the minimum number of coins to make the amount.
     * @param coins the coin denominations
     * @param amount the target amount
     * @return the minimum number of coins or -1
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        java.util.Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * Sample: LeetCode 300. Longest Increasing Subsequence
     * Time: O(n^2), Space: O(n)
     * Finds the length of the longest increasing subsequence.
     * @param nums the array
     * @return the length of LIS
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        java.util.Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}