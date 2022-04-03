package Offer24;

/**
 * Definition for singly-linked list.
 * public class Offer24.ListNode {
 * int val;
 * Offer24.ListNode next;
 * Offer24.ListNode(int x) { val = x; }
 * }
 */

//思路：用node保存当前结点，用pre保存前一个结点，否则链表会断裂
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode node = head;
        while (node != null) {
            ListNode temp = node.next;//用临时变量保存当前结点的下一个结点
            node.next = pre;//当前结点的next域指向前一个结点
            pre = node;//后移
            node = temp;//后移
        }
        return pre;//不能返回node，因为node在最后一次循环指向了temp，而temp这时候已经为null
    }
}