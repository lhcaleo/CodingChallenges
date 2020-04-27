class Solution 
{
	public int[][] matrixReshape(int[][] nums, int r, int c) 
	{
		if (nums == null || nums.length == 0) return null;
		
		int row = nums.length;
		int col = nums[0].length;
		if (row * col != r * c) return nums;
		
		int[][] res = new int[r][c];
		int index = 0;
		
		// index / col = entry's row
		// index % col = entry's column
		for (int i = 0; i < r; i++)
		{
			for (int j = 0; j < c; j++ )
			{
				res[i][j] = nums[index / col][index % col];
				index++;
			}
		}
		return res;
	}
}