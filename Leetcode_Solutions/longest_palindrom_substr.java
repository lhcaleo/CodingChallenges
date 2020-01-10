// Dynamic Programming
// Time: O(n^2) for double loops Space: O(n^2) for 2d array
class Solution 
{
	public String longestPalindrome(String s) 
	{
		if (s.isEmpty() || s == null) 
			return s;
		
		String result = "";
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		
		for (int j = 0; j < len; j++)
		{
			for (int i = 0; i <= j; i++)
			{
				dp[i][j] = s.charAt(i) == s.charAt(j) && ((j-i) <= 2 || dp[i+1][j-1]);
				if (dp[i][j] && j - i + 1 > result.length())
				{
					result = s.substring(i, j + 1);
				}
			}
		}
		return result;
	}
}


// https://leetcode.com/problems/longest-palindromic-substring/
// Expand Around Center
// Time: O(n^2) Space: O(1)
class Solution 
{
	String result = "";
	public String longestPalindrome(String s) 
	{
		if (s.isEmpty() || s == null)
			return s;
		for (int i = 0; i < s.length(); i++)
		{
			expandAroundCenter(s, i, i);
			expandAroundCenter(s, i, i+1);
		}
		return result;   
	}
	private void expandAroundCenter(String s, int left, int right)
	{
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
		{
			left--;
			right++;
		}
		String current = s.substring(left + 1, right);
		if (current.length() > result.length())
			result = current;
	}
}