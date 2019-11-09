// https://leetcode.com/problems/fibonacci-number/
// Recursion Time: O(2^N) Space: O(N) max size of the stack
class Solution 
{
	public int fib(int N) 
	{
		if(N==0 || N==1) return N;
		return fib(N-1) + fib(N-2);
	}
}
// Bottom-Up Using Memorization
// Time & Space: O(n)
class Solution 
{
	public int fib(int N) 
	{
		if(N==0 || N==1) return N;
		else
		{
			int[] fibs = new int[N+1];
			fibs[0] = 0;
			fibs[1] = 1;
			for(int i = 2; i < N+1; i++)
			{
				fibs[i] = fibs[i-1] + fibs[i-2];
			}
			return fibs[N];
		}
	}
}



