// Time: O(n) Space: O(n)

class Solution 
{
	public int longestConsecutive(int[] nums) 
	{
		if (nums == null || nums.length == 0) 
			return 0;

		HashSet<Integer> set = new HashSet<>(); 
		for (int num : nums) set.add(num);
	  
		int longest = 0;
		for (int num : nums) 
		{
			int left = num - 1;
			int right = num + 1;
			
			while (set.remove(left)) left--;
			while (set.remove(right)) right++;
			
			longest = Math.max(longest, right - left - 1);
		   
			// save time if there are items in nums, but no item in hashset.
			if (set.isEmpty()) 
				return longest;
		}
		
		return longest;
	}
}