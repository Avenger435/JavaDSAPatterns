package com.java.patterns.leet;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    // Sorting Template
    // Sorts the array (using built-in sort)
    public void sortingTemplate(int[] arr) {
        java.util.Arrays.sort(arr);
    }

    // Sample Problem for Sorting: LeetCode 75. Sort Colors
    // Time Complexity: O(n), Space Complexity: O(1)
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Sample Problem for Sorting: LeetCode 56. Merge Intervals
    // Time Complexity: O(n log n), Space Complexity: O(n)
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][];
        java.util.Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                current[1] = Math.max(current[1], intervals[i][1]);
            } else {
                result.add(current);
                current = intervals[i];
            }
        }
        result.add(current);
        return result.toArray(new int[result.size()][]);
    }
}