// https://leetcode.com/problems/perfect-squares/
// (Max or Min Value Type) Dynamic Programming
// Time: O(n*n)  n* sqrt(n)
// Space: O(n)

class Solution 
{
	public int numSquares(int n) 
	{
		// 0...n: [n+1]
		int[] f = new int[n+1];
		
		// initialization
		// f[x] least # of square numbers to sum to x
		Arrays.fill(f, Integer.MAX_VALUE);
		f[0] = 0;

		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= Math.sqrt(i); j++)
			{
				f[i] = Math.min(f[i], f[i - j*j] + 1);
				// least # of square numbers to sum to i =  
				// Min of ( least # to sum up to i-j^2) 
				//  (leaset # to sum up to i)

			}
		}
		return f[n];
	}
}