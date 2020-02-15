// https://leetcode.com/problems/valid-palindrome-ii/
// Two Pointer
// Time: O(n) Space: O(1)
class Solution 
{
	public boolean validPalindrome(String s) 
	{
		int left = 0;
		int right = s.length() - 1;
		while (left <= right)
		{
			if (s.charAt(left) == s.charAt(right))
			{
				left++;
				right--;
			}
			else
			{
				// we can delete element pointed by left pointer, or element pointed by right pointer
				return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
			}
		}
		return true;
	}
	
	private boolean isPalindrome(String s, int left, int right)
	{
		while(left <= right)
		{            
			if (s.charAt(left) == s.charAt(right))
			{
				left++;
				right--;
			}
			else
			{
				return false;
			}
		}
		return true;
	}
}