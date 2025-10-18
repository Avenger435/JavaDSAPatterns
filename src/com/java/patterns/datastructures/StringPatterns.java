package com.java.patterns.datastructures;

/**
 * StringPatterns class provides templates and sample problems for string operations.
 * Includes sliding window, two pointers, KMP, and Rabin-Karp.
 */
public class StringPatterns {

    /**
     * Template: Sliding Window for strings.
     * Finds the longest substring with certain properties.
     * @param s the string
     * @return the length of the longest substring
     */
    public int slidingWindowTemplate(String s) {
        int left = 0;
        int maxLength = 0;
        int[] count = new int[128]; // Assuming ASCII
        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right)]++;
            // Shrink window if condition not met
            // while (condition) {
            //     count[s.charAt(left)]--;
            //     left++;
            // }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    /**
     * Template: Two Pointers for strings.
     * Checks for palindromes or reverses.
     * @param s the string
     * @return true if palindrome, false otherwise
     */
    public boolean twoPointersTemplate(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * Template: KMP (Knuth-Morris-Pratt) for pattern matching.
     * Computes prefix table and searches.
     * @param text the text
     * @param pattern the pattern
     * @return the starting index or -1
     */
    public int kmpTemplate(String text, String pattern) {
        int[] lps = computeLPS(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                if (j == pattern.length()) return i - j;
            } else {
                if (j > 0) j = lps[j - 1];
                else i++;
            }
        }
        return -1;
    }

    private int[] computeLPS(String pattern) {
        int[] lps = new int[pattern.length()];
        int len = 0, i = 1;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) len = lps[len - 1];
                else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * Sample: LeetCode 5. Longest Palindromic Substring
     * Time: O(n^2), Space: O(1)
     * Finds the longest palindromic substring.
     * @param s the string
     * @return the longest palindrome
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length
            int len2 = expandAroundCenter(s, i, i + 1); // Even length
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Sample: LeetCode 28. Implement strStr()
     * Time: O(n + m), Space: O(m)
     * Implements string search using KMP.
     * @param haystack the text
     * @param needle the pattern
     * @return the index or -1
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        return kmpTemplate(haystack, needle);
    }

    /**
     * Sample: LeetCode 242. Valid Anagram
     * Time: O(n), Space: O(1)
     * Checks if two strings are anagrams.
     * @param s the first string
     * @param t the second string
     * @return true if anagram, false otherwise
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) count[c - 'a']++;
        for (char c : t.toCharArray()) count[c - 'a']--;
        for (int num : count) if (num != 0) return false;
        return true;
    }
}