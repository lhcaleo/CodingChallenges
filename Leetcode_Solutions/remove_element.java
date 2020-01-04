// https://leetcode.com/problems/remove-element/
// Two pointer solution, only keep and count valid elements
// Time: O(n), Space: O(1)
class Solution 
{
	public int removeElement(int[] nums, int val) 
	{
		if (nums.length == 0) return 0;
		int i = 0;
		for (int num: nums) 
		{
			if (num != val)
			{
				// keep it and continue
				nums[i] = num;
				i++;
			}
		}
		return i;
	}
}