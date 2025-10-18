package com.java.patterns.datastructures;

import java.util.PriorityQueue;

/**
 * HeapPatterns class provides templates and sample problems for heap (priority queue) operations.
 * Includes top K elements, median finding, and heap sort.
 */
public class HeapPatterns {

    /**
     * Template: Min-Heap operations.
     * Demonstrates adding and removing elements.
     */
    public void minHeapTemplate() {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.offer(5); // Add element
        minHeap.offer(1);
        int min = minHeap.peek(); // Get min without removing
        int removed = minHeap.poll(); // Remove and return min
    }

    /**
     * Template: Max-Heap using reverse order.
     * Demonstrates max-heap operations.
     */
    public void maxHeapTemplate() {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.offer(1);
        maxHeap.offer(5);
        int max = maxHeap.peek(); // Get max
    }

    /**
     * Sample: LeetCode 215. Kth Largest Element in an Array
     * Time: O(n log k), Space: O(k)
     * Finds the kth largest element using a min-heap.
     * @param nums the array
     * @param k the kth position
     * @return the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Keep only k largest
            }
        }
        return minHeap.peek();
    }

    /**
     * Sample: LeetCode 23. Merge k Sorted Lists
     * Time: O(n log k), Space: O(k)
     * Merges k sorted linked lists using a min-heap.
     * @param lists the list of sorted lists
     * @return the merged sorted list
     */
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) minHeap.offer(list);
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            current.next = node;
            current = current.next;
            if (node.next != null) minHeap.offer(node.next);
        }
        return dummy.next;
    }

    // ListNode class for samples
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}