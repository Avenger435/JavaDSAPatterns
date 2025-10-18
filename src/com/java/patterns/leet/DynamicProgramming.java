package com.java.patterns.leet;

public class DynamicProgramming {

    // Dynamic Programming Template
    // Uses DP array for subproblems
    public int dpTemplate(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Sample Problem for Dynamic Programming: LeetCode 53. Maximum Subarray
    // Time Complexity: O(n), Space Complexity: O(1)
    public int maxSubArray(int[] nums) {
        int maxCurrent = nums[0], maxGlobal = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) maxGlobal = maxCurrent;
        }
        return maxGlobal;
    }

    // Sample Problem for Dynamic Programming: LeetCode 198. House Robber
    // Time Complexity: O(n), Space Complexity: O(1)
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }
}