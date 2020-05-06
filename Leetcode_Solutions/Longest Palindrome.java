// Time: O(n) Space: O(1) since array_size is a constant
class Solution 
{
	public int longestPalindrome(String s) 
	{
		// Since 'A' = 65 'z' = 122, array size is then 122 - 65 + 1 = 58
		int[] count = new int[58];
		
		// count # of appearance of each letter
		for (char c: s.toCharArray())
		{
			count[c - 'A']++;
		}
		
		int ans = 0;
		
		// for each letter appears t times, we can use it t / 2 * 2 times
		// t/2 times for left side of the palindrome, and t/2 times for right side
		// if one letter appears odd times, use it as the center of the palindrome
		// only one odd letter can be used as the center
		for (int t: count)
		{
			ans += (t / 2) * 2;
			// once found the center odd letter, if condition will never be executed anymore
			if (ans % 2 == 0 && t % 2 != 0)
				ans++;
		}
		
		return ans;
	}
}