// Time: O(n) for array iteration Space: O(n) one stack + one array
class Solution 
{
	public int[] dailyTemperatures(int[] T) 
	{
		int len = T.length;
		int[] res = new int[len];
		Stack<Integer> stack = new Stack<>();
		
		for (int warmer_index = 0; warmer_index < len; warmer_index++)
		{
			while (!stack.isEmpty() && T[warmer_index] > T[stack.peek()])
			{
				int reference_index = stack.peek();
				stack.pop();
				// distance of these 2 days is the diff of their index
				
				res[reference_index] = warmer_index - reference_index;
			}
			stack.push(warmer_index);
		}
		
		return res;
	}
}