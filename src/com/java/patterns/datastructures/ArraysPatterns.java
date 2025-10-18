package com.java.patterns.datastructures;

import java.util.Arrays;

public class ArraysPatterns {

	public static void main(String[] args) {
		System.out.println("Patterns for Arrays in Java");
		int[] nums = { 5, 4, 6, 2, 7, 3 };
		traverse(nums);
		int[] prefixSum = prefixSum(nums);
		traverse(prefixSum);
		reverse(nums);
		System.out.println(Arrays.toString(nums));
		int[] maxMinArr = findMaxMin(nums);
		System.out.println("maxMinArr: " + Arrays.toString(maxMinArr));
		System.out.println("Linear Search: " + linearSearch(nums, 7));

		int[] dupNums = { 2, 3, 3, 4, 4, 4, 5, 6 };
		int removeDuplicates = removeDuplicates(dupNums);
		System.out.println("Remove dups: " + removeDuplicates);

	}

	public static void traverse(int[] nums) {
		System.out.println("nums");
		for (int num : nums) {
			System.out.print(num + " ");
		}
		System.out.println();
	}

	public static int[] prefixSum(int[] nums) {
		int[] prefix = new int[nums.length];
		prefix[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prefix[i] = prefix[i - 1] + nums[i];
		}
		return prefix;
	}

	public static void reverse(int[] nums) {
		int left = 0;
		int right = nums.length - 1;

		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	public static int[] findMaxMin(int[] nums) {
		int max = nums[0];
		int min = nums[0];
		for (int num : nums) {
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		return new int[] { max, min };
	}

	public static int linearSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target)
				return i;
		}
		return -1;
	}

	public static int removeDuplicates(int[] nums) {
		if (nums.length == 0)
			return 0;
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[j] != nums[i]) {
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	public static int[] twoSum(int[] nums, int target) {
		int left = 0, right = nums.length - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target)
				return new int[] { left, right };
			else if (sum < target)
				left++;
			else
				right--;
		}
		return new int[] { -1, -1 };

	}
}
