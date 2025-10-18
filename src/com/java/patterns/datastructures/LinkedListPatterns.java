package com.java.patterns.datastructures;

/**
 * LinkedListPatterns class provides templates and sample problems for linked list operations.
 * Includes common patterns like traversal, reversal, and cycle detection.
 */
public class LinkedListPatterns {

    /**
     * Node class for singly linked list.
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    /**
     * Template: Traversal of a linked list.
     * Iterates through the list and processes each node.
     * @param head the head of the linked list
     */
    public void traverse(ListNode head) {
        ListNode current = head;
        while (current != null) {
            // Process current.val (e.g., print or modify)
            System.out.println(current.val);
            current = current.next;
        }
    }

    /**
     * Template: Reversal of a linked list.
     * Reverses the pointers to reverse the list.
     * @param head the head of the linked list
     * @return the new head of the reversed list
     */
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next; // Store next node
            current.next = prev; // Reverse the link
            prev = current; // Move prev to current
            current = next; // Move to next node
        }
        return prev; // New head
    }

    /**
     * Sample: LeetCode 206. Reverse Linked List
     * Time: O(n), Space: O(1)
     * Reverses a singly linked list.
     * @param head the head of the linked list
     * @return the reversed linked list
     */
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }

    /**
     * Sample: LeetCode 21. Merge Two Sorted Lists
     * Time: O(n + m), Space: O(1)
     * Merges two sorted linked lists into one sorted list.
     * @param list1 the first sorted list
     * @param list2 the second sorted list
     * @return the merged sorted list
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // Dummy node for easy handling
        ListNode current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        // Append remaining nodes
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    /**
     * Sample: LeetCode 141. Linked List Cycle
     * Time: O(n), Space: O(1)
     * Detects if there is a cycle in the linked list using fast and slow pointers.
     * @param head the head of the linked list
     * @return true if cycle exists, false otherwise
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow by 1
            fast = fast.next.next; // Move fast by 2
            if (slow == fast) return true; // Cycle detected
        }
        return false;
    }
}