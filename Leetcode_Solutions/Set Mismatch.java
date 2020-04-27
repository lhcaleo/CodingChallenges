// Time: O(n) Space: O(1)
class Solution 
{
	public int[] findErrorNums(int[] nums) 
	{
		int dup = -1;
		int missing = 1;

		for (int n: nums) 
		{
			// if negative, it's duplicate
			if (nums[Math.abs(n) - 1] < 0)
				dup = Math.abs(n);
			else
				// fisrt visit of a number, change it to negative
				nums[Math.abs(n) - 1] *= -1;
		}

		for (int i = 1; i < nums.length; i++)
		{
			if (nums[i] > 0)
				missing = i + 1;
		}
			  
		return new int[]{dup, missing};
	}
}
