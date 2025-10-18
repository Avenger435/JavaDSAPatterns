package com.java.patterns.datastructures;

import java.util.*;

/**
 * BitManipulationPatterns class provides templates and sample problems for bit manipulation.
 * Includes bit operations, subsets, and XOR tricks.
 */
public class BitManipulationPatterns {

    /**
     * Template: Count number of 1 bits.
     * Counts the number of set bits in an integer.
     * @param n the number
     * @return the count of 1 bits
     */
    public int countBitsTemplate(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    /**
     * Template: Generate subsets using bit manipulation.
     * Generates all subsets of a set.
     * @param nums the array
     * @return the list of subsets
     */
    public List<List<Integer>> subsetsTemplate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int total = 1 << n; // 2^n
        for (int i = 0; i < total; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }
        return result;
    }

    /**
     * Template: XOR tricks for finding single number.
     * Finds the number that appears once.
     * @param nums the array
     * @return the single number
     */
    public int singleNumberTemplate(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * Sample: LeetCode 136. Single Number
     * Time: O(n), Space: O(1)
     * Finds the number that appears only once.
     * @param nums the array
     * @return the single number
     */
    public int singleNumber(int[] nums) {
        return singleNumberTemplate(nums);
    }

    /**
     * Sample: LeetCode 191. Number of 1 Bits
     * Time: O(1), Space: O(1)
     * Counts the number of 1 bits in an integer.
     * @param n the number
     * @return the count
     */
    public int hammingWeight(int n) {
        return countBitsTemplate(n);
    }

    /**
     * Sample: LeetCode 78. Subsets
     * Time: O(2^n * n), Space: O(2^n * n)
     * Generates all subsets of the array.
     * @param nums the array
     * @return the list of subsets
     */
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsTemplate(nums);
    }
}