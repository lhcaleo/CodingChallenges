/*
 A hash map
 pointer - point to head initially
 index - point to current char
 maxLen = index - pointer + 1
 
 1. Check if current char is in map, if yes, update pointer as index's next
 2. Compute Max
 3. Update hash set
*/
// https://leetcode.com/problems/longest-substring-without-repeating-characters/
// Sliding window, Hashmap, Two Pointers
// n: string length, m:size of the charset 
// Time: O(n)  
// Space: O(min(n,m)) size of map is upper bounded by n and m

public class Solution 
{
	public int lengthOfLongestSubstring(String s) 
	{
		int n = s.length();
		// HashMap check costs O(1)
		Map<Character, Integer> map = new HashMap<>();
		int maxLen = 0;
		
		for(int index = 0, pointer = 0; index < n; index++)
		{
			if(map.containsKey(s.charAt(index)))
			{
				// pointer can only move to the right
				// updat pointer as index's next, or do not update
				pointer = Math.max(map.get(s.charAt(index)) + 1, pointer);
			}
			// whether to update max length or not
			maxLen = Math.max(index - pointer + 1, maxLen);
			
			// store char as key and index as value
			map.put(s.charAt(index), index);
		}
		return maxLen;
	}
}