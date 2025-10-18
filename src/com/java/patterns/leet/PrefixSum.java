package com.java.patterns.leet;

import java.util.HashMap;
import java.util.Map;

public class PrefixSum {

    // Prefix Sum Template
    // Precompute prefix sums for efficient range queries
    public int[] prefixSumTemplate(int[] arr) {
        int[] prefix = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        return prefix;
    }

    // Sample Problem for Prefix Sum: LeetCode 560. Subarray Sum Equals K
    // Time Complexity: O(n), Space Complexity: O(n)
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Sample Problem for Prefix Sum: LeetCode 303. Range Sum Query - Immutable
    // Time Complexity: Build O(n), Query O(1), Space Complexity: O(n)
    static class NumArrayPrefix {
        int[] prefix;

        NumArrayPrefix(int[] nums) {
            prefix = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }
}