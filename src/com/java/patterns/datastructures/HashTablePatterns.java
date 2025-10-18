package com.java.patterns.datastructures;

import java.util.*;

/**
 * HashTablePatterns class provides templates and sample problems for hash table operations.
 * Includes frequency counting, two sum variants, and grouping.
 */
public class HashTablePatterns {

    /**
     * Template: Frequency counting using HashMap.
     * Counts occurrences of elements.
     * @param arr the array
     * @return the frequency map
     */
    public Map<Integer, Integer> frequencyCount(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    /**
     * Template: Two Sum using HashMap.
     * Finds two numbers that add up to target.
     * @param nums the array
     * @param target the target sum
     * @return the indices of the two numbers
     */
    public int[] twoSum(int[] nums, int target) {
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

    /**
     * Template: Grouping using HashMap.
     * Groups elements by a key.
     * @param strs the array of strings
     * @return the grouped map
     */
    public Map<String, List<String>> groupByAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return map;
    }

    /**
     * Sample: LeetCode 1. Two Sum
     * Time: O(n), Space: O(n)
     * Finds two numbers that add up to target.
     * @param nums the array
     * @param target the target sum
     * @return the indices
     */
    public int[] twoSumSample(int[] nums, int target) {
        return twoSum(nums, target);
    }

    /**
     * Sample: LeetCode 49. Group Anagrams
     * Time: O(n * k log k), Space: O(n * k)
     * Groups strings that are anagrams.
     * @param strs the array of strings
     * @return the grouped list
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = groupByAnagram(strs);
        return new ArrayList<>(map.values());
    }

    /**
     * Sample: LeetCode 128. Longest Consecutive Sequence
     * Time: O(n), Space: O(n)
     * Finds the longest consecutive sequence.
     * @param nums the array
     * @return the length of the longest sequence
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int maxLength = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) { // Start of sequence
                int current = num;
                int length = 1;
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}