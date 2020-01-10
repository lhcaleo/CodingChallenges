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