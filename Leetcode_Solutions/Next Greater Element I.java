// Time: O(m) for num2 iteration, Space: O(n + n) for one stack and one hashmap 
// Key: using one single-order stack (elements decreasing from top to bottom)
class Solution 
{
	public int[] nextGreaterElement(int[] nums1, int[] nums2) 
	{
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i < nums2.length; i++)
		{
			while (!stack.isEmpty() && nums2[i] > stack.peek())
			{
				// key: element, value: its greater element
				map.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}
		
		for (int j = 0; j < nums1.length; j++)
		{
			nums1[j] = map.getOrDefault(nums1[j], -1);
		}
		
		return nums1;
	}
}