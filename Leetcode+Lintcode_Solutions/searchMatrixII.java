// https://leetcode.com/problems/search-a-2d-matrix-ii/
// Binary Search. Time: O(m+n) better than brute force O(m*n)


class Solution 
{
	public boolean searchMatrix(int[][] matrix, int target)
	{
		if(matrix == null || matrix.length == 0) return false;

		int row = 0;
		int col = matrix[0].length - 1; 
		// start compareing with last element at first row
		// if element > target, we can ignore the element's column
		// if element < target, we can ignore the elements' row
		while(row < matrix.length && col >= 0)
		{
			if(matrix[row][col] == target) return true;
			if(matrix[row][col] > target)
			{
				col--;
			}
			else
			{
				row++;
			}
		}
		return false;
	}
}