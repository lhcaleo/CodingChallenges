// Time: O(2n) -> O(n) for array iteration Space: O(n) for one stack and one array
// key: using module % to simulate circular array
class Solution 
{
	public int[] nextGreaterElements(int[] nums) 
	{
		int len = nums.length;
		int[] res = new int[len];
		Arrays.fill(res, -1);
		Stack<Integer> stack = new Stack<>();
		
		for (int greater_index = 0; greater_index < len * 2; greater_index++)
		{   
			int greater_num = nums[greater_index % len];
			
			while (!stack.isEmpty() && greater_num > nums[stack.peek()])
			{
				int reference_index = stack.pop();
				res[reference_index] = greater_num;
			}
			
			if (greater_index < len)
				stack.push(greater_index);
		}
		
		return res;
	}
}