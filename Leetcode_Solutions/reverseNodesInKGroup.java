// Time: O(n * k) Space: O(1)
// Optimal Time: O(n) Worst Time: O(n^2)

class Solution 
{
	public ListNode reverseKGroup(ListNode head, int k) 
	{
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;
		
		// previous node of the head of sub-list
		ListNode prev = dummyHead;
		// tail node of the sub-list
		ListNode end = dummyHead;
		
		while (end != null)
		{
			// move pointer towards the tail node
			for (int i = 0; i < k && end != null; i++)
			{
				end = end.next;
			}
			if (end == null)
				break;
			
			// head node of the sub-list
			ListNode start = prev.next;
			// record the head of next sub-list to be reversed
			ListNode next = end.next;
			// set the next pointer of end to be null, assign later
			end.next = null;
			
			// prev's next is now the original end node of reversed sub-list
			prev.next = reverse(start);
			// start is actually the original end node
			// this links reversed sub-list and next sub-list to be reversed
			start.next = next;
			
			// reset prev and end pointer for the next iteration
			prev = start;
			end = prev;
		}
		
		return dummyHead.next;   
	}
	
	private ListNode reverse(ListNode head)
	{
		// prev curr next
		ListNode prev = null;
		ListNode curr = head;
		
		while (curr != null)
		{
			ListNode next = curr.next;
			curr.next = prev; // reverse the next pointer
			prev = curr;
			curr = next;
		}
		
		return prev;
	}
}