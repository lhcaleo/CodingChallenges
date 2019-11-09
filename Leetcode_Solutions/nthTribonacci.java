// https://leetcode.com/problems/n-th-tribonacci-number/
// Time & Space: O(n)
// Recursion without repeated computations
class Solution 
{
	public int tribonacci(int n) 
	{ 
		if(n == 0) return 0;
		else if (n == 1 || n == 2) return 1;
		else 
		{
			// use array to store previous computation
			int[] tribs = new int[n + 1];
			tribs[0] = 0;
			tribs[1] = 1;
			tribs[2] = 1;
			for (int i = 3; i < n + 1; i++){
				tribs[i] = tribs[i - 1] + tribs[i - 2] + tribs[i - 3];
			}
			return tribs[n];
		}
	}
}