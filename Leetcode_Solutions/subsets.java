// https://leetcode.com/problems/subsets/
// Time: O(n * 2^n) Space：O(n)
// backtracking
class Solution 
{
	List<List<Integer>> result = new ArrayList<>();
	
	public List<List<Integer>> subsets(int[] nums) 
	{
		List<Integer> track = new ArrayList<>();
		backtrack(nums, 0, track);
		return result;
	}
	
	private void backtrack(int[] nums, int offset, List<Integer> track)
	{
		// creating a new array list takes O(N)
		result.add(new ArrayList(track));
		
		for (int i = offset; i < nums.length; i++)
		{
			// it keeps adding and removing the element for all possible combinations - O(2^N)
			track.add(nums[i]);
			backtrack(nums, i + 1, track); 
			track.remove(track.size() - 1);
		}
	}
}