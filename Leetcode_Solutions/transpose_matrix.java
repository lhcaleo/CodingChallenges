// https://leetcode.com/problems/transpose-matrix/
// Time: O(row * col) Space: O(row * col)
class Solution 
{
	public int[][] transpose(int[][] A) 
	{
		int[][] transA = new int[A[0].length][A.length];
		
		for (int i = 0; i < A.length; i++)
		{
			for (int j = 0; j < A[0].length; j++)
			{
				transA[j][i] = A[i][j];
			}
		}
		return transA;
	}
}