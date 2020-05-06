// Use Array instead of HashMap 
// Time: O(n) Space: O(1) since array_size(26) is a constant
class Solution 
{
	public boolean isAnagram(String s, String t) 
	{
		if (s.length() != t.length())
			return false;
		
		int[] alphabets = new int[26];
		
		for (int i = 0; i < s.length(); i++)
		{
			alphabets[s.charAt(i) - 'a']++;
			alphabets[t.charAt(i) - 'a']--;
		}
		
		for (int i = 0; i < 26; i++)
		{
			if (alphabets[i] != 0)
				return false;
		}
		
		return true;
	}
}

// HashMap Solution
// Time: O(n) Space: O(n)
class Solution 
{
	public boolean isAnagram(String s, String t) 
	{
		if (s.length() != t.length())
			return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for (int i = 0; i < t.length(); i++)
		{
			char c = t.charAt(i);
			if (map.get(c) == null)
				return false;
			else if (map.get(c) > 0)
				map.replace(c, map.get(c) - 1);
			else
				return false;
		}
		
		return true;
	}
}