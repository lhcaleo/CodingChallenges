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

// top-down appraoch
// recursion with memorization
// Time and Space O(n)
class Solution
{
	public int climbStairs(int n) 
	{
			if (n < 0) return 0; 
			if (n == 0) return 1; 
			if (n < 3) return n;

			int[] memo = new int[n+1];
			memo[1] = 1;
			memo[2] = 2;

			return climb(n, memo);
	}
	
	private int climb(int n, int[] memo) 
	{
		if (memo[n] == 0) 
		{
			memo[n] = climb(n-2, memo) + climb(n-1, memo);
		}
		return memo[n];
	}
}

// Best, O(n) time O(1) space
// Iterative botton-up
class Solution 
{
	public int climbStairs(int n)
	{
		if(n==1 || n==0) return n;
		int prev = 1;   // 0 stage, 1 sol
		int curr = 1;   // 1 stage, 1 sol
		int next = 0;
		// note: # of steps for n = # of steps of n-1 and n-2
		for(int i = 2; i <= n; i++)
		{
			next = prev + curr;
			prev = curr;
			curr = next;
		}
		return curr;
	}
}