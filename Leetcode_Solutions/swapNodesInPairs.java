// Dummy Head with 3 pointers, prev, left, and right
// Time: O(n) Space: O(1)
class Solution 
{
	public ListNode swapPairs(ListNode head) 
	{
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		ListNode prev = dummyHead;
		
		while (prev.next != null && prev.next.next != null)
		{
			ListNode left = prev.next;
			ListNode right = prev.next.next;
			ListNode next = right.next;
			
			left.next = next;
			right.next = left;
			prev.next = right;
			
			prev = left;
		}
		
		return dummyHead.next;
	}
}