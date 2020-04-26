// Time: O(n) Space:O(n)
class Solution 
{
	public int findLHS(int[] nums) 
	{
		HashMap<Integer, Integer> map = new HashMap<>();
		
		// key: number, value: # of times appear
		for (int n: nums)
		{
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		int longest = 0;
		
		// difference between max and min is exactly 1
		for (int n: map.keySet())
		{
			if (map.containsKey(n + 1))
				longest = Math.max(longest, map.get(n) + map.get(n + 1));
		}
		
		return longest;
	}
}