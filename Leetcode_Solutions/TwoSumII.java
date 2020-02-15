// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Two Pointer
// Time: O(n) Space: O(1)
class Solution 
{
	public int[] twoSum(int[] numbers, int target) 
	{
		int left = 0;
		int right = numbers.length - 1;
		int sum = 0;
		
		while(left < right)
		{
			sum = numbers[left] + numbers[right];
			if (sum == target)
			{
				break;
			}
			else if (sum > target)
			{
				right--;
			}
			// sum < target
			else 
			{
				left++;
			}
		}
		
		return new int[]{left + 1, right + 1};
	}
}