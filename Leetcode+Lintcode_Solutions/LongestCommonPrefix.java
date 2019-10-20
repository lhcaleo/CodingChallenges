// https://leetcode.com/problems/longest-common-prefix/
// Write a function to find the longest common prefix string amongst an array of strings.
// If there is no common prefix, return an empty string "".
class Solution
{
	public String longestCommonPrefix(String[] strs)
	{
		if(strs.length == 0) return "";
		// treat first string as the prefix
		for(int i = 0; i < strs[0].length() ; i++)
		{
			for(int j = 1; j < strs.length; j++)
			{
				if(strs[j].length() <= i) 
				{
					// if meets shorter or equal length string 
					// return current result, otherwise will get string index exception
					return strs[0].substring(0,i);
				}
				if(strs[0].charAt(i) != strs[j].charAt(i))
				{
					// if chars matches, continue
					// otherwise, return this current longest common prefix
					return strs[0].substring(0,i);
				}
			}
		}
		return strs[0];
	}
}