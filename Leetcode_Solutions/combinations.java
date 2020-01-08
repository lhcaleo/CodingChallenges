// https://leetcode.com/problems/combinations/
// Backtracking
// Time: O(k * C(n,k)) time Space: O(k)
class Solution 
{
	List<List<Integer>> result = new ArrayList();
	int n,k;
		
	public List<List<Integer>> combine(int n, int k) 
	{
		this.n = n;
		this.k = k;
		backtrack(1, new ArrayList<Integer>());
		return result;
	}

	public void backtrack(int offset, ArrayList<Integer> track) 
	{
		if (track.size() == k)
			result.add(new ArrayList(track));

		for (int i = offset; i < n + 1; ++i) 
		{
			track.add(i);
			backtrack(i + 1, track);
			track.remove(track.size() - 1);
		}
	}
}
