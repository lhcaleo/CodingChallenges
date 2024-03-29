// https://leetcode.com/problems/merge-two-sorted-lists/
// Dummy Head
// Time: O(m+n) Space: O(1)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution 
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while (l1 != null && l2 != null)
		{
			if (l1.val < l2.val)
			{
				head.next = l1;
				l1 = l1.next;
			} 
			else
			{
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		head.next = (l1 == null)? l2: l1;
		return dummy.next;
	}
}


// Recursion, https://www.youtube.com/watch?v=qckKEYP9bBA
// Time: O(m+n) Space: O(m+n)

class Solution 
{
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{
		// Base Case
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.val < l2.val)
		{
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} 
		else
		{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}
}