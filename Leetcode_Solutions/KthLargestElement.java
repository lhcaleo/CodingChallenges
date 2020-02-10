// quicksort
class Solution 
{
	public int findKthLargest(int[] nums, int k) 
	{
		quickSort(nums, 0, nums.length - 1);
		return nums[nums.length - k];
	}
	
	private void quickSort(int[] nums, int start, int end)
	{
		if (start >= end) return;
		int pivot_index = partition(nums, start, end);
		quickSort(nums, start, pivot_index - 1);
		quickSort(nums, pivot_index + 1, end);
	}
	
	private int partition(int[] nums, int start, int end)
	{
		int pivot = nums[start];
		int k = start + 1;
		
		for (int i = start + 1; i <= end; i++)
		{
			if (nums[i] < pivot)
			{
				swap(nums, i, k);
				k++;
			}
		}
		k--;
		swap(nums, k, start);
		return k;
	}
	
	private void swap(int[] nums, int a, int b)
	{
		int temp = 0;
		temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}