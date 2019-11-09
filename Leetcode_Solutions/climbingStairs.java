// https://leetcode.com/problems/climbing-stairs/
// Dynamic Programming
// Time & Space: O(n)
class Solution 
{
	public int climbStairs(int n) 
	{
		if (n == 0) return 0;
		if (n == 1) return 1;
	
		int[] ways = new int[n + 1];
		ways[0] = ways[1] = 1;  
		
		for (int i = 2; i <= n; i++) 
		{
			ways[i] = ways[i - 2] + ways[i - 1];
		}
		return ways[n];
	}
}

// Recursive solution (TLE at input 44)
// Easy to understand
class Solution 
{
	public int climbStairs(int n) 
	{
		switch(n) 
		{
			case 0: 
				return 0;
			case 1: 
				return 1;
			case 2: 
				return 2;
			default: 
				return climbStairs(n-1) + climbStairs(n-2);
		}
	}
}

