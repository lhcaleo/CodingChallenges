// https://leetcode.com/problems/sum-of-square-numbers/
// Two Pointer
// Time: O(n) Space: O(1)
class Solution 
{
	public boolean judgeSquareSum(int c) 
	{
		int left = 0;
		int right = (int) Math.sqrt(c);
		int sum = 0;
		
		while (left <= right)
		{
			sum = left * left + right * right;
			if (sum == c)
			{
				return true;
			}
			else if (sum < c) 
			{
				left++;
			}
			else 
			{
				right--;
			}
		}
		return false;
	}
}