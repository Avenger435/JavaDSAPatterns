# Copilot Instructions for Creating Code Templates and Sample Problems

This document provides guidelines for generating Java code templates and sample problems for various data structures commonly used in LeetCode patterns. The goal is to create reusable, efficient implementations that demonstrate key algorithms and patterns.

## General Guidelines
- **File Structure**: Create a separate Java class for each data structure in the `src/com/java/patterns/` directory (e.g., `arrays/TwoPointers.java`).
- **Templates**: Include pseudo-code or template methods with placeholders for customization.
- **Sample Problems**: Add 1-2 concrete LeetCode-style problems per major pattern, with full implementations.
- **Complexity**: Add time and space complexity comments above each sample method.
- **Imports**: Include necessary imports at the top.
- **Edge Cases**: Handle basic edge cases in samples.
- **Compilation**: Ensure code compiles without errors.

## Data Structures and Patterns

### 1. Arrays
- **Patterns**: Two Pointers, Sliding Window, Prefix Sum, Binary Search, Sorting, In-place Modifications.
- **Templates**: Provide methods for each pattern variation (e.g., opposite ends, same direction for two pointers).
- **Samples**: Two Sum, Longest Substring Without Repeating Characters, Maximum Subarray Sum.

### 2. Linked Lists
- **Patterns**: Traversal, Fast-Slow Pointers, Reversal, Cycle Detection, Merging.
- **Templates**: Singly linked list node class, methods for insertion/deletion, reversal.
- **Samples**: Reverse Linked List, Merge Two Sorted Lists, Detect Cycle.

### 3. Stacks
- **Patterns**: Monotonic Stack, Expression Evaluation, Parentheses Matching.
- **Templates**: Stack-based solutions for next greater element, valid parentheses.
- **Samples**: Valid Parentheses, Daily Temperatures, Largest Rectangle in Histogram.

### 4. Queues
- **Patterns**: BFS (Breadth-First Search), Sliding Window Maximum, Deque for Monotonic Queue.
- **Templates**: Queue implementations, BFS template.
- **Samples**: Binary Tree Level Order Traversal, Sliding Window Maximum.

### 5. Trees
- **Patterns**: DFS (Depth-First Search), BFS, Tree Traversal (Inorder, Preorder, Postorder), BST Operations.
- **Templates**: Tree node class, recursive/iterative traversal methods.
- **Samples**: Invert Binary Tree, Validate BST, Lowest Common Ancestor.

### 6. Binary Search Trees (BST)
- **Patterns**: Insertion, Deletion, Search, Inorder Traversal.
- **Templates**: BST operations with balancing considerations.
- **Samples**: Insert into BST, Delete Node in BST, Kth Smallest Element.

### 7. Heaps (Priority Queues)
- **Patterns**: Top K Elements, Median Finding, Heap Sort.
- **Templates**: Min-heap/Max-heap implementations.
- **Samples**: Kth Largest Element, Merge K Sorted Lists.

### 8. Graphs
- **Patterns**: DFS, BFS, Topological Sort, Shortest Path (Dijkstra, Bellman-Ford), Cycle Detection.
- **Templates**: Adjacency list representation, DFS/BFS templates.
- **Samples**: Number of Islands, Course Schedule, Network Delay Time.

### 9. Hash Tables (HashMap/HashSet)
- **Patterns**: Frequency Counting, Two Sum Variants, Grouping.
- **Templates**: Hash-based lookups and counters.
- **Samples**: Two Sum, Group Anagrams, Longest Consecutive Sequence.

### 10. Strings
- **Patterns**: Sliding Window, Two Pointers, KMP, Rabin-Karp.
- **Templates**: String manipulation with pointers.
- **Samples**: Longest Palindromic Substring, Implement strStr, Valid Anagram.

### 11. Dynamic Programming
- **Patterns**: 1D/2D DP, Knapsack, Longest Common Subsequence.
- **Templates**: DP table initialization and filling.
- **Samples**: Climbing Stairs, Coin Change, Longest Increasing Subsequence.

### 12. Bit Manipulation
- **Patterns**: Bit Operations, Subsets, XOR Tricks.
- **Templates**: Bitwise operations for common problems.
- **Samples**: Single Number, Number of 1 Bits, Subsets.

### 13. Advanced Topics
- **Patterns**: Union-Find, Trie, Segment Tree, Fenwick Tree.
- **Templates**: Implementations for each.
- **Samples**: Redundant Connection, Word Search II, Range Sum Query.

## Implementation Steps
1. **Identify Patterns**: For each data structure, list common LeetCode patterns.
2. **Create Templates**: Write generic methods with comments explaining usage.
3. **Add Samples**: Implement specific problems using the templates.
4. **Validate**: Check for compilation errors and correctness.
5. **Document**: Add comments for complexities and explanations.

Use these instructions to systematically build a comprehensive library of data structure patterns for interview preparation.