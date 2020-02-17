// Observation: numbers appear in pairs, the single element must have an even index
// [1,1,2,3,3,4,4,8,8]
//  0,1,2,3,4,5,6,7,8
// Binary Search
// Time: O(log n) Space: O(1)
class Solution 
{
	public int singleNonDuplicate(int[] nums) 
	{
		int start = 0;
		int end = nums.length - 1;
		int mid = 0;
		
		while (start < end)
		{
			mid = start + (end - start) / 2;
			// make sure mid is even
			if (mid % 2 == 1)
			{
				mid--;
			}
			
			// We found a pair. The single element must be on the right.
			// Example: |1 1 3 3 5 6 6|
			//               ^ ^
			// Next:     1 1 3 3|5 6 6|
			if (nums[mid] == nums[mid + 1])
			{
				start = mid + 2;
			}
			
			// We didn't find a pair. The single element must be on the left.
			// Example: |0 1 1 3 3 6 6|
			//               ^ ^
			// Next:    |0 1 1|3 3 6 6
			else
			{
				end = mid;
			}
		}
		return nums[start];
	}
}