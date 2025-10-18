package com.java.patterns.datastructures;

import java.util.Stack;

/**
 * StackPatterns class provides templates and sample problems for stack-based operations.
 * Includes patterns like monotonic stack and parentheses matching.
 */
public class StackPatterns {

    /**
     * Template: Basic stack operations.
     * Demonstrates push, pop, and peek.
     */
    public void basicStackOperations() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1); // Push element
        int top = stack.peek(); // Get top without removing
        int popped = stack.pop(); // Remove and return top
    }

    /**
     * Template: Monotonic Stack for next greater element.
     * Finds the next greater element for each element in the array.
     * @param nums the input array
     * @return array of next greater elements
     */
    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop(); // Remove smaller elements
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

    /**
     * Sample: LeetCode 20. Valid Parentheses
     * Time: O(n), Space: O(n)
     * Checks if the string has valid parentheses.
     * @param s the input string
     * @return true if valid, false otherwise
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    /**
     * Sample: LeetCode 739. Daily Temperatures
     * Time: O(n), Space: O(n)
     * Finds the number of days to wait for warmer temperature.
     * @param temperatures the array of temperatures
     * @return array of days to wait
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>(); // Stack of indices
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * Sample: LeetCode 84. Largest Rectangle in Histogram
     * Time: O(n), Space: O(n)
     * Finds the largest rectangle area in the histogram.
     * @param heights the array of heights
     * @return the largest rectangle area
     */
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        int n = heights.length;
        for (int i = 0; i <= n; i++) {
            int h = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && h < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        return maxArea;
    }
}