// Mapping two chars at the same position to the same value
class Solution 
{
	public boolean isIsomorphic(String s, String t) 
	{
		int len = s.length();
		int[] map_s = new int[128];
		int[] map_t = new int[128];
		
		for (int i = 0; i < len; i++)
		{
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			if (map_s[c1] != map_t[c2])
				return false;
			else
			{
				map_s[c1] = i + 1;
				map_t[c2] = i + 1;
			}
		}
		
		return true;   
	}
}

/*
The idea is that we need to map a char to another one, for example, "egg" and "add", we need to constract the mapping 'e' -> 'a' and 'g' -> 'd'. Instead of directly mapping 'e' to 'a', another way is to mark them with same value, for example, 'e' -> 1, 'a'-> 1, and 'g' -> 2, 'd' -> 2, this works same.

So we use two arrays here m1 and m2, initialized space is 256 (Since the whole ASCII size is 256, 128 also works here). Traverse the character of both s and t on the same position, if their mapping values in m1 and m2 are different, means they are not mapping correctly, returen false; else we construct the mapping, since m1 and m2 are both initialized as 0, we want to use a new value when i == 0, so i + 1 works here.
*/