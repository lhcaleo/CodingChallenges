// https://leetcode.com/problems/jump-game/
// (True or False Type) Dynamic Programming (note: may use && || operators)
// Time: O(n^2)  Space: O(n) size of array
class Solution 
{
	public boolean canJump(int[] nums) 
	{
		int n = nums.length;
		// f[j] indicates if it can jump to stone j
		boolean[] f = new boolean[n];
		// initialization
		f[0] = true; 
		
		for(int j = 1; j < n; j++)
		{
			f[j] = false;
			// previous stone i
			// last jump from i to j
			for(int i = 0; i < j; i++)
			{
				// when stone i can reached and can jump from i to j
				if(f[i] && i + nums[i] >= j)
				{
					f[j] = true;
					break;
				}
			}
		}
		return f[n-1];
	}
}