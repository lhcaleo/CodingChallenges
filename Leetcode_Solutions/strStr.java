// https://leetcode.com/problems/implement-strstr/
// Assume n = length of haystack, m = length of needle
// Time: O(nm) Space: O(1)
class Solution 
{
	public int strStr(String haystack, String needle) 
	{
		if (needle.length() == 0)
			return 0;
		if (haystack.length() == 0 || haystack.length() < needle.length())
			return -1;
		for (int i = 0; i < haystack.length() - needle.length() + 1 ; i++)
		{
			for (int j = 0; j < needle.length(); j++)
			{
				if (needle.charAt(j) != haystack.charAt(i+j))
					break;
				if (j == needle.length() - 1) 
					return i;
			}
		}
		return -1;
	}
}