// Time: O(n + k) Space: O(k)
class Solution 
{
	public ListNode[] splitListToParts(ListNode root, int k) 
	{
		// Get length of list
		int length = 0;
		ListNode temp = root;
		while (temp != null)
		{
			length++;
			temp = temp.next;
		}
		
		int mod = length % k;
		int size = length / k;
		
		// Create an array of k lists
		ListNode[] result = new ListNode[k];
		
		ListNode curr = root;
		for (int i = 0; curr != null & i < k; i++)
		{
			result[i] = curr;
			int curr_size = 0;
			
			if (mod > 0) 
			{
				curr_size = size + 1;
				mod--;
			} else {
				curr_size = size;
			}
			for (int j = 0; j < curr_size - 1; j++)
			{
				curr = curr.next;
			}
			ListNode nextHead = curr.next;
			curr.next = null;
			curr = nextHead;
		}
		
		return result;
	}
}