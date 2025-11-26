package com.java.patterns.leet;

import java.util.Arrays;

public class PrefixSumTemplate {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6 };

		prefixSum(nums);
		int rangeSum = rangeSum(new int[] { 0, 1, 3, 6, 10, 15, 21 }, 1, 4);
		System.out.println("rangeSum: " + rangeSum);
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		twoDprefixSum(matrix);
		int twoDRangeSum = twoDRangeSum(
				new int[][] { { 0, 0, 0, 0 }, { 0, 1, 3, 6 }, { 0, 5, 12, 21 }, { 0, 12, 27, 45 } }, 1, 1, 2, 2);
		System.out.println("twoDRangeSum: " + twoDRangeSum);

		slidingWindowPrefixSum(nums, 3);
		slidingWindowPrefixSum2D(matrix, 2);

		print2DArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });

		print1DArray(new int[] { 1, 2, 3, 4, 5 });

		int[] prefixSumArray = buildPrefixSumArray(nums);
		System.out.println("Built Prefix Sum Array: " + Arrays.toString(prefixSumArray));
		int[][] prefixSum2DArray = build2DPrefixSumArray(matrix);
		System.out.println("Built 2D Prefix Sum Array: " + Arrays.deepToString(prefixSum2DArray));
		int[] productArray = productArrayItself(new int[] { 1, 2, 3, 4 });
		System.out.println("Product Array Itself: " + Arrays.toString(productArray));

	}

	public static void prefixSum(int[] nums) {

		int[] prefixSum = new int[nums.length + 1];

		for (int i = 1; i <= nums.length; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}

		System.out.println(Arrays.toString(prefixSum));

	}

	public static int rangeSum(int[] prefixSum, int left, int right) {
		return prefixSum[right + 1] - prefixSum[left];
	}

	public static void twoDprefixSum(int[][] matrix) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] prefixSum = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
						+ matrix[i - 1][j - 1];
			}
		}

		System.out.println(Arrays.deepToString(prefixSum));

	}

	public static int twoDRangeSum(int[][] prefixSum, int row1, int col1, int row2, int col2) {
		return prefixSum[row2 + 1][col2 + 1] - prefixSum[row1][col2 + 1] - prefixSum[row2 + 1][col1]
				+ prefixSum[row1][col1];
	}

	public static void slidingWindowPrefixSum(int[] nums, int k) {

		int n = nums.length;
		int[] prefixSum = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}

		for (int i = k; i <= n; i++) {
			int windowSum = prefixSum[i] - prefixSum[i - k];
			System.out.println("Window sum for index " + (i - k) + " to " + (i - 1) + " is: " + windowSum);
		}

	}

	public static void slidingWindowPrefixSum2D(int[][] matrix, int k) {

		int rows = matrix.length;
		int cols = matrix[0].length;

		int[][] prefixSum = new int[rows + 1][cols + 1];

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
						+ matrix[i - 1][j - 1];
			}
		}

		for (int i = k; i <= rows; i++) {
			for (int j = k; j <= cols; j++) {
				int windowSum = prefixSum[i][j] - prefixSum[i - k][j] - prefixSum[i][j - k] + prefixSum[i - k][j - k];
				System.out.println("Window sum for index (" + (i - k) + "," + (j - k) + ") to (" + (i - 1) + ","
						+ (j - 1) + ") is: " + windowSum);
			}
		}

	}

	public static void print2DArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void print1DArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static int[] buildPrefixSumArray(int[] nums) {
		int n = nums.length;
		int[] prefixSum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
		}
		return prefixSum;
	}

	public static int[][] build2DPrefixSumArray(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] prefixSum = new int[rows + 1][cols + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1]
						+ matrix[i - 1][j - 1];
			}
		}
		return prefixSum;
	}

	public static int[] productArrayItself(int[] nums) {
		int n = nums.length;
		int[] leftProduct = new int[n];
		int[] rightProduct = new int[n];
		int[] ans = new int[n];
		leftProduct[0] = 1;
		rightProduct[n - 1] = 1;

		for (int i = 1; i < n; i++) {
			leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
		}
		for (int i = n - 2; i >= 0; i--) {
			rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
		}

		for (int i = 0; i < n; i++)
			ans[i] = rightProduct[i] * leftProduct[i];

		return ans;
	}
}
