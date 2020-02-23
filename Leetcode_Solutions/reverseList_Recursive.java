class Solution 
{
	public ListNode reverseList(ListNode head) 
	{
		ListNode curr = head;
		// if curr is null,
		// if curr'next is null, it means it's the last node
		//    which will become head of the reverse list.
		if (curr == null || curr.next == null)
			return curr;
		
		ListNode curr_next = curr.next;
		ListNode newHead = reverseList(curr_next);
		curr_next.next = curr;
		curr.next = null;
		
		return newHead;
	}
}




/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * https://leetcode.com/problems/reverse-linked-list/
 * https://www.youtube.com/watch?v=MRe3UsRadKw
 */

// Recursive Solution
class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode curr = head;
		// if curr is null,
		// if curr'next is null, it means it's the last node
		//    which will become head of the reverse list.
		if(curr == null || curr.next == null) return curr;
		ListNode p = reverseList(curr.next);
		curr.next.next = curr;
		curr.next = null;
		return p;
	}
}