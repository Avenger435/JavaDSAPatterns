package com.java.patterns.leet;

public class InPlaceOperations {

    // In-place Operations Template
    // Modifies array in-place
    public void inPlaceTemplate(int[] arr) {
        // Example: reverse array
        int left = 0, right = arr.length - 1;
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Sample Problem for In-place Operations: LeetCode 189. Rotate Array
    // Time Complexity: O(n), Space Complexity: O(1)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Sample Problem for In-place Operations: LeetCode 26. Remove Duplicates from Sorted Array
    // Time Complexity: O(n), Space Complexity: O(1)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}