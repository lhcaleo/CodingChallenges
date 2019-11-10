// https://leetcode.com/problems/unique-paths/
// Dynamic Programming Time & Space: O(m*n)
class Solution 
{
	public int uniquePaths(int m, int n) 
	{
		int[][] f = new int[m][n];
		for(int i = 0; i < m; i++) // row: top to bottom
		{
			for(int j = 0; j < n; j++) // column: left to right
			{
				if(i == 0 || j == 0) f[i][j] = 1; // initialization
				else
				{
					f[i][j] = f[i-1][j] + f[i][j-1];
				}
			}
		}
		return f[m-1][n-1]; 
	}
}