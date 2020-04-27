// Binary Search the matrix
// https://leetcode.com/problems/search-a-2d-matrix/submissions/
// Time: O(log m*n) = O(log m + log n)

class Solution 
{
	public boolean searchMatrix(int[][] matrix, int target) 
	{
		if (matrix == null || matrix.length == 0) 
			return false;
		// m rows, n columns
		int m = matrix.length;
		int n = matrix[0].length; 
		
		int start = 0;
		int end = m * n - 1;
		
		while (start <= end)
		{
			int mid = start + (end-start) / 2;
			int x = mid / n; // row index
			int y = mid % n; // column index
			
			if (matrix[x][y] == target)
			{
				return true;
			}
			else if (matrix[x][y] < target)
			{
				start = mid + 1;
			}
			else
			{
				end = mid - 1;
			}
		}    
		
		return false;    
	}
}

//	Basic Approach
//	Time: O(m*n) 	
//	public boolean searchMatrix(int[][] matrix, int target) 
//	{
//		if(matrix == null || matrix.length == 0) return false;
//		int m = matrix.length;
//		int n = matrix[0].length;   
//		
//		for(int i = 0; i < m; i++)
//		{
//			for(int j = 0; j < n; j++)
//			{
//				if(matrix[i][j] == target) return true; 
//			}
//		}
//		return false;
//	}