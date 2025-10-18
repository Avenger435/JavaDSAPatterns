package com.java.patterns.leet;

public class SlidingWindow {

    // Fixed Size Sliding Window Template
    // Use when window size is constant, e.g., max sum of subarray of size k
    public int fixedWindowTemplate(int[] arr, int k) {
        if (arr.length < k) return -1; // or handle edge case
        int maxSum = 0;
        // Calculate initial window sum
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int currentSum = maxSum;
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            currentSum = currentSum - arr[i - k] + arr[i];
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Variable Size Sliding Window Template (for maximum length)
    // Use when finding the longest subarray/substring meeting a condition
    public int variableWindowMaxLength(int[] arr, int target) {
        int left = 0;
        int maxLength = 0;
        int currentSum = 0;
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            // Shrink window if condition not met (e.g., sum > target)
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            // Update maxLength if condition met
            if (currentSum <= target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }
        return maxLength;
    }

    // Variable Size Sliding Window Template (for minimum length)
    // Use when finding the shortest subarray/substring meeting a condition
    public int variableWindowMinLength(int[] arr, int target) {
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            // Shrink window while condition met
            while (currentSum >= target && left <= right) {
                minLength = Math.min(minLength, right - left + 1);
                currentSum -= arr[left];
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}