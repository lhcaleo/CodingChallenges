/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// https://leetcode.com/problems/add-two-numbers/
// Multiple lists probelm -> use of **dummy head**
// Time: O(Max(l1.length,l2.length))
// Space: O(Max(l1.length,l2.length) + 1)

class Solution 
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		int sum = 0;
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;
		while(l1 != null || l2 != null)
		{
			if(l1 != null)
			{
				sum += l1.val;
				l1 = l1.next;
			}
			if(l2 != null)
			{
				sum += l2.val;
				l2 = l2.next;
			}
			curr.next = new ListNode(sum % 10);
			sum = sum / 10; // carry for next         
			curr = curr.next;
		}
		// if at the end, there is a carry
		if(sum > 0)
		{
			curr.next = new ListNode(sum);
		}
		return dummy.next;
	}
}