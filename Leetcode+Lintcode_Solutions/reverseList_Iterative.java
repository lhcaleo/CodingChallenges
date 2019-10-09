/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * https://leetcode.com/problems/reverse-linked-list/
 */
class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode newHead = null;
		// stop when head is null
		while(curr != null){
			newHead = curr.next;
			curr.next = prev;
			// move two pointers forward
			prev = curr;
			curr = newHead;
		}
		return prev;
	}
}