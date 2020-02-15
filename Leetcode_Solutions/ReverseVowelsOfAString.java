// https://leetcode.com/problems/reverse-vowels-of-a-string/
// Two Pointer 
// Time: O(n) Space: O(1) constant

class Solution 
{
	// use a HashSet to reduce the look up time to O(1)
	private final static HashSet<Character> vowels = new HashSet<>(
		Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	
	public String reverseVowels(String s) 
	{
		if (s == null)
			return null;
		int left = 0;
		int right = s.length() - 1;
		
		char[] result = new char[s.length()];
		
		while (left <= right)
		{
			char cLeft = s.charAt(left);
			char cRight = s.charAt(right);
			
			if (!vowels.contains(cLeft))
			{
				result[left] = cLeft;
				left++;
			}
			else if (!vowels.contains(cRight))
			{
				result[right] = cRight;
				right--;
			}
			else 
			{
				result[left] = cRight;
				result[right] = cLeft;
				left++;
				right--;
			}
		}
		return new String(result);
	}
}