// https://leetcode.com/problems/majority-element/
// By HashMap Time: O(n) Space: O(n)
class Solution 
{
	public int majorityElement(int[] nums) 
	{
		if (nums.length == 1) return nums[0];
		int half_len = nums.length / 2;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int num: nums)
		{
			if (!map.containsKey(num))
			{
				map.put(num, 1);
			}
			else
			{
				map.put(num, map.get(num) + 1);
				if (map.get(num) > half_len)
					return num;
			}
		}
		return 1;
	}
}