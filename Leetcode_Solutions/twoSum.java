import java.util.*;
// --------------------------------------------------------------------
// Use One HashMap
// O(n) for array traversing, hashmap put and get costs only O(1) time
// O(n) space for storing at most n elements into hashmap
class Solution {
	public int[] twoSum(int[] nums, int target) 
	{
		HashMap<Integer,Integer> map = new HashMap<>();
		int complement = 0;
		for(int i = 0; i < nums.length; i++)
		{
			complement = target - nums[i];
			// if the complement is in the map
			// return indices i and complement's index
			if(map.containsKey(complement))
			{
				return new int[]{i, map.get(complement)};
			}
			map.put(nums[i],i);
		}
		throw new IllegalArgumentException("No solution is found"); 
	}
}


// --------------------------------------------------------------------
// Sort and Search with 2 pointer
// O(nlogn) time and O(n) space for new array
class Solution {
	public int[] twoSum(int[] nums, int target) {
		// Sorted array
		int[] arr = Arrays.copyOf(nums, nums.length);
		Arrays.sort(arr); // built-in quicksort for primitives O(nlogn)
		
		// Search		
		int start= 0;
		int end = nums.length - 1;
		// indices a,b for return
		int a,b = 0;
		// two pointers take O(n) time
		while(start < end)
		{
			if(arr[start] + arr[end] == target)
			{
				a = 0;
				b = nums.length - 1;
				// find their indices a,b totally cost O(n)
				while(a < nums.length && nums[a] != arr[start]) a++;
				while(b >= 0 && nums[b] != arr[end]) b--;
				return new int[]{a,b};
			}
			else if (arr[start] + arr[end] < target) 
			{
				start++;
			}
			else
			{
				end--;	
			}
		}
		throw new IllegalArgumentException("No solution is found");
	}
}


// --------------------------------------------------------------------
// Brute force solution
// O(n^2) time and O(1) space
class Solution {
	public int[] twoSum(int[] nums, int target) {
		for(int i = 0; i < nums.length; i++ )
		{
			for(int j = i+1; j < nums.length; j++)
			{
				if(nums[i]+nums[j]==target)
				{
					return new int[]{i,j};     
				}
			}
		}
		throw new IllegalArgumentException("No solution is found");
	}
}