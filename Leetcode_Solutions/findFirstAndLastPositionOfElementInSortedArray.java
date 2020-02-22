class Solution 
{
	public int[] searchRange(int[] nums, int target) 
	{
		
		if (nums == null || nums.length == 0)
			return new int[]{-1, -1};
		
		int first = lower_bound(nums, target);
		int last = upper_bound(nums, target) - 1;

		if (first == nums.length || nums[first] != target)
			return new int[]{-1, -1};
		else
			return new int[]{first, Math.max(first, last)};
	}
	
	// first index of i, such that nums[i] >= target
	private int lower_bound(int[] nums, int target)
	{
		int left = 0;
		int right = nums.length;
		int mid = 0;
		
		while (left < right)
		{
			mid = left + (right - left) / 2;
			if (nums[mid] >= target)
				right = mid;
			else
				// mid < target
				left = mid + 1; 
		}
		return left;
	}
	
	// first index of i, such that nums[i] > target
	private int upper_bound(int[] nums, int target)
	{
		int left = 0;
		int right = nums.length;
		int mid = 0;
		
		while (left < right)
		{
			mid = left + (right - left) / 2;
			if (nums[mid] > target)
				right = mid;
			else
				// mid <= target
				left = mid + 1; 
		}
		return left;
	}
}