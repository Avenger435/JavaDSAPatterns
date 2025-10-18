package com.java.patterns.datastructures;

public class SlidingWindowPattern {

	public void slidingWindow(String s, String t) {

		int left = 0;
		int right = 0;

		while (right < s.length()) {
			// expand window by including s.charAt(right)
			right++;

			// while the window is invalid (doesn't meet the condition),
			// shrink from the left

			while (true) { // window is invalid
				left++;
			}

			// update result if needed (e.g., minimum or maximum length
		}

	}

}
