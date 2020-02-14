// one-pass algorithm using 3 pointers
// p0 point to the rightmost boundary of 0s
// p2 point to the leftmost boundary of 2s
// curr point to the current number

// Time: O(n) Space: O(1)

class Solution 
{
	public void sortColors(int[] nums)
	{
		int p0 = 0;
		int current = 0;
		int p2 = nums.length - 1;
		
		while (current <= p2)
		{
			// swap move both pointer to the right
			if (nums[current] == 0)
				swap(nums, current++, p0++);
			// swap and move p2 to the left
			else if (nums[current] == 2)
				swap(nums, current, p2--);
			// if current element is 1, just move current pointer to the right
			else 
				current++;
		}
	}
	
	private void swap(int[] nums, int a, int b)
	{
		int temp = 0;
		temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}