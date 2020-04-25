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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		Stack<Integer> s1 = newStack(l1);
		Stack<Integer> s2 = newStack(l2);
		
		ListNode head = new ListNode(0);
		int carry = 0;
		
		while (!s1.isEmpty() || !s2.isEmpty() || carry != 0)
		{
			int x = s1.isEmpty() ? 0: s1.pop();
			int y = s2.isEmpty() ? 0: s2.pop();
			int sum = x + y + carry;
			carry = sum / 10;
			ListNode node = new ListNode(sum % 10);
			node.next = head.next;
			head.next = node;
		}
		return head.next;
	}
	
	private Stack<Integer> newStack(ListNode node)
	{
		Stack<Integer> stack = new Stack<>();
		while (node != null)
		{
			stack.push(node.val);
			node = node.next;
		}
		return stack;
	}
}
