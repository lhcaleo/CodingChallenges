// Time: O(n) Space: O(1)
// Two Pointer and Reverse list

class Solution 
{
	public boolean isPalindrome(ListNode head) 
	{
		if (head == null || head.next == null) 
			return true;
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
		}
		// even length, move slow one more step, 
		// else odd length, slow is already in the mid
		if (fast != null)
			slow = slow.next;
		// split to two lists
		splitList(head, slow);
		// compare first and reversed-second
		return compareList(head, reverseList(slow));     
	}
	
	private void splitList(ListNode head, ListNode end)
	{
		while (head.next != end)
		{
			head = head.next;
		}
		head.next = null;
	}
	
	private ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		ListNode newHead = null;
		// stop when head is null
		while (curr != null)
		{
			newHead = curr.next;
			curr.next = prev;
			prev = curr;
			curr = newHead;
		}
		return prev;
	}
	
	private boolean compareList(ListNode l1, ListNode l2)
	{
		while (l1 != null && l2 != null)
		{
			if (l1.val == l2.val) {
				l1 = l1.next;
				l2 = l2.next;
			} else {
				return false;
			}
		}
		return true;
	}
}