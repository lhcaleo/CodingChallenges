// Expand around center
// Time: O(n^2) Space: O(1)
class Solution 
{
	private int count = 0;
	
	public int countSubstrings(String s) 
	{
		for (int i = 0; i < s.length(); i++)
		{
			// idea: expand around center
			extend_substrings(s, i, i);   // even length
			extend_substrings(s, i, i + 1); // odd length
		}
		
		return count;
	}
	
	private void extend_substrings(String s, int left, int right)
	{
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
		{
			count++;
			left--;
			right++;
		}
	}
}