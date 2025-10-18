package com.java.patterns.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hashing {

    // Hashing Template
    // Uses HashMap for frequency or lookups
    public Map<Integer, Integer> hashingTemplate(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    // Sample Problem for Hashing: LeetCode 217. Contains Duplicate
    // Time Complexity: O(n), Space Complexity: O(n)
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) return true;
        }
        return false;
    }

    // Sample Problem for Hashing: LeetCode 1. Two Sum (HashMap version)
    // Time Complexity: O(n), Space Complexity: O(n)
    public int[] twoSumHash(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}