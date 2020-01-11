/**
 * https://leetcode.com/problems/linked-list-cycle/
 * two pointer with different speed
 * Time: O(n) if no cycle
 * Time: non-cyclic length N, cyclic length = K
 *  distance between 2 runners / speed diff = # of loops for them to meet = K/(2-1) = K
 *  thus, time is O(N+K)
 * Space: O(1)

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution 
{
	public boolean hasCycle(ListNode head) 
	{
		if (head == null || head.next == null) return false;
		ListNode slow = head;
		ListNode fast = head.next;
		
		while (slow != fast)
		{
			if (slow.next == null || fast.next == null || fast.next.next == null) 
				return false;
			else
			{
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return true;
	}
}

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * Time: O(n)
 * Space: O(n)
 */
public class Solution 
{
	public boolean hasCycle(ListNode head) 
	{
		Set<ListNode> set = new HashSet<>();
		
		while (head != null)
		{
			if (set.contains(head))
				return true;
			else
			{
				set.add(head);
				head = head.next;
			}
		}
		return false;
	}
}