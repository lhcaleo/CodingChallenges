// Binary Search
class Solution
{
	public int kthSmallest(int[][] matrix, int k) 
	{
		int n = matrix.length;
		int left = matrix[0][0];
		int right = matrix[n - 1][n - 1];
		
		while (left <= right) 
		{
			int mid = left + (right - left) / 2;
			int count = 0;
			
			for (int i = 0; i < n; i++) 
			{
				for (int j = 0; j < n; j++) 
				{
					if (matrix[i][j] <= mid)
						count++;
				}
			}
			
			if (count < k) 
				left = mid + 1;
			else 
				right = mid - 1;
		}
		
		return left;
	}
}
// PriorityQueue - Max Queue
// Max Queue

class Solution 
{
	public int kthSmallest(int[][] matrix, int k) 
	{
		int n = matrix.length;
		PriorityQueue<Integer> max_queue = new PriorityQueue<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer t1, Integer t2)
			{
				return t2 - t1;
			}
		});
		
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				max_queue.add(matrix[i][j]);
				if (max_queue.size() > k)
				{
					max_queue.poll();
				}
			}
		}
		
		return max_queue.peek();
	}
}