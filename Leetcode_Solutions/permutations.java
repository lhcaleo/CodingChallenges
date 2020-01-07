// https://leetcode.com/problems/permutations/
// Time: O(n!) Space: O(n) using backtracking

class Solution
{
	List<List<Integer>> result = new ArrayList<>();
	
	public List<List<Integer>> permute(int[] nums) 
	{
		List<Integer> track = new ArrayList<>();
		backtrack(nums, track);
		return result;
	}
	
	private void backtrack(int[] nums, List<Integer> track)
	{
		// termination
		if (track.size() == nums.length)
		{
			result.add(new ArrayList(track));
			return;
		}
		
		for (int i = 0; i < nums.length; i++)
		{
			// ignore invalid choice
			if (track.contains(nums[i]))
				continue;
			// select
			track.add(nums[i]);
			backtrack(nums, track);
			// unselect
			track.remove(track.size() - 1);
		}
	}
}