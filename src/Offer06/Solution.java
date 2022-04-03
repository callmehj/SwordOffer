package Offer06;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for singly-linked list.
 * public class Offer24.ListNode {
 * int val;
 * Offer24.ListNode next;
 * Offer24.ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack = new ArrayDeque<>();
//        Offer24.ListNode node = head;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}