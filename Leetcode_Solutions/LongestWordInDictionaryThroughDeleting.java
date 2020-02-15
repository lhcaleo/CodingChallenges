// Two Pointer with subStr()
// Time: O(s*d)  Space: O(1) 
class Solution 
{
	public String findLongestWord(String s, List<String> d) 
	{
		String longest = "";
		for (String str: d)
		{
			int l1 = longest.length();
			int l2 = str.length();
			// if str is shorter than longest word, or same length with smaller order
			if (l1 > l2 || (l1 == l2) && (longest.compareTo(str) < 0))
			{
				continue;
			}
			if (isSubstr(s, str))
			{
				longest = str;
			}
		}
		return longest;
	}
	private boolean isSubstr(String s, String str)
	{
		int i = 0;
		int j = 0;
		while (i < s.length() && j < str.length())
		{
			if (s.charAt(i) == str.charAt(j))
			{
				j++;
			}
			i++;
		}
		return j == str.length();
	}
}