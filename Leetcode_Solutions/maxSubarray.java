// https://leetcode.com/problems/maximum-subarray/
// Time: O(n)   1d dynamic programming
// Space: O(n)
class Solution 
{
	public int maxSubArray(int[] nums) 
	{
		// f[i] // max value of maxSubArray(0...i)
		// f[i] = f[i-1] > 0? nums[i] + f[i-1] : nums[i];
		int[] f = new int[nums.length];
		f[0] = nums[0];
		int max = f[0];
		for(int i = 1; i < nums.length; i++)
		{
			f[i] = Math.max(f[i-1] + nums[i], nums[i]);
			if(f[i] > max)
			{
				max = f[i];
			}
		}    
		return max;
	}
}

// https://leetcode.com/problems/maximum-subarray/
// Time: O(n)   1d dynamic programming
// Space: O(1)  
class Solution 
{
	public int maxSubArray(int[] nums) 
	{
		// f[i] // max value of maxSubArray(0...i)
		// f[i] = f[i-1] > 0? nums[i] + f[i-1] : nums[i];
		int sum = nums[0];
		int max = nums[0];
		for(int i = 1; i < nums.length; i++)
		{
			sum = Math.max(sum + nums[i], nums[i]);
			if(sum > max)
			{
				max = sum;
			}
		}    
		return max;
	}
}