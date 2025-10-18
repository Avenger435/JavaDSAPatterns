package com.java.patterns.leet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoPointers {

    // Opposite Ends Two Pointer Template
    public void oppositeEndsTemplate(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            // Process arr[left] and arr[right]
            if (true) {
                left++;
            } else {
                right--;
            }
        }
    }

    // Same Direction Two Pointer Template
    public void sameDirectionTemplate(int[] arr) {
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            // Expand window with arr[right]
            while (true) {
                // Shrink window from left
                left++;
            }
            // Process current window [left, right]
        }
    }

    // Fast and Slow Pointer Template
    public void fastSlowTemplate(int[] arr) {
        int slow = 0;
        int fast = 0;
        while (fast < arr.length && fast + 1 < arr.length) {
            slow++;
            fast += 2;
            // Check for meeting point or condition
        }
    }

    // Sample Problem for Opposite Ends: Two Sum (assuming sorted array)
    // Time Complexity: O(n), Space Complexity: O(1)
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left + 1, right + 1}; // 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }

    // Sample Problem for Same Direction: Longest Substring Without Repeating Characters
    // Time Complexity: O(n), Space Complexity: O(min(n, m)) where m is the character set size
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Sample Problem for Fast and Slow: Find the Duplicate Number (array with n+1 elements, values 1 to n)
    // Time Complexity: O(n), Space Complexity: O(1)
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

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

    // Binary Search Template
    // Searches for target in sorted array
    public int binarySearchTemplate(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Sample Problem for Binary Search: LeetCode 35. Search Insert Position
    // Time Complexity: O(log n), Space Complexity: O(1)
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    // Sample Problem for Binary Search: LeetCode 162. Find Peak Element
    // Time Complexity: O(log n), Space Complexity: O(1)
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }

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
        java.util.List<int[]> result = new java.util.ArrayList<>();
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

    // Matrix Traversal Template
    // Traverses 2D array in spiral order
    public java.util.List<Integer> spiralTemplate(int[][] matrix) {
        java.util.List<Integer> result = new java.util.ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int j = left; j <= right; j++) result.add(matrix[top][j]);
            top++;
            // Traverse down
            for (int i = top; i <= bottom; i++) result.add(matrix[i][right]);
            right--;
            // Traverse left
            if (top <= bottom) {
                for (int j = right; j >= left; j--) result.add(matrix[bottom][j]);
                bottom--;
            }
            // Traverse up
            if (left <= right) {
                for (int i = bottom; i >= top; i--) result.add(matrix[i][left]);
                left++;
            }
        }
        return result;
    }

    // Sample Problem for Matrix Traversal: LeetCode 54. Spiral Matrix
    // Time Complexity: O(m * n), Space Complexity: O(1) excluding output
    public java.util.List<Integer> spiralOrder(int[][] matrix) {
        return spiralTemplate(matrix);
    }

    // Sample Problem for Matrix Traversal: LeetCode 73. Set Matrix Zeroes
    // Time Complexity: O(m * n), Space Complexity: O(1)
    public void setZeroes(int[][] matrix) {
        boolean firstRowZero = false, firstColZero = false;
        int m = matrix.length, n = matrix[0].length;
        // Check first row and column
        for (int j = 0; j < n; j++) if (matrix[0][j] == 0) firstRowZero = true;
        for (int i = 0; i < m; i++) if (matrix[i][0] == 0) firstColZero = true;
        // Mark rows and columns
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // Set zeroes
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        // Set first row and column
        if (firstRowZero) for (int j = 0; j < n; j++) matrix[0][j] = 0;
        if (firstColZero) for (int i = 0; i < m; i++) matrix[i][0] = 0;
    }

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