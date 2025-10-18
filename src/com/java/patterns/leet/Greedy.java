package com.java.patterns.leet;

public class Greedy {

    // Greedy Template
    // Makes local optimal choices
    public int greedyTemplate(int[] arr) {
        int result = 0;
        // Example: accumulate positives
        for (int num : arr) {
            if (num > 0) result += num;
        }
        return result;
    }

    // Sample Problem for Greedy: LeetCode 55. Jump Game
    // Time Complexity: O(n), Space Complexity: O(1)
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) return false;
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= nums.length - 1) return true;
        }
        return true;
    }

    // Sample Problem for Greedy: LeetCode 121. Best Time to Buy and Sell Stock
    // Time Complexity: O(n), Space Complexity: O(1)
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) minPrice = price;
            else if (price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }
}