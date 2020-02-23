/*
 * length of A: a + c
 * length of B: b + c
 * so, a + c + b = b + c + a
 * Time: O(n) Space: O(1)
*/
public class Solution 
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) 
	{
	
		ListNode a = headA;
		ListNode b = headB;
		
		// Wait for a and b both be null or the same
		while (a != b) 
		{
			if (a == null) a = headB;
			else a = a.next;
			
			if (b == null) b = headA;
			else b = b.next;
		}
		
		return a;
	}
}