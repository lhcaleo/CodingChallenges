// Two Pointer Solution
// Time: O(n) for array iteration  Space: O(n) for extra char array
class Solution 
{
	public String reverseWords(String s) 
	{
		if (s == null)
			return s;
		
		char[] a = s.toCharArray();
		
		// step 1: reverse each word
		reverse_words(a);
		
		// step 2: reverse the whole string
		reverse(0, a.length - 1, a);
		
		// step 3: clean multiple spaces
		return clean_spaces(a);
	}
	
	private void reverse_words(char[] a)
	{
		int i = 0;
		int j = 0;
		int len = a.length;
		
		while (i < len)
		{
			while (i < j || i < len && a[i] == ' ') i++; // skip spaces
			while (j < i || j < len && a[j] != ' ') j++; // skip non-spaces
			reverse(i, j - 1, a); // reverse this word
		}
	}
	
	private void reverse(int i, int j, char[] a)
	{
		while (i < j)
		{
			char temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}
	
	private String clean_spaces(char[] a)
	{
		int len = a.length;
		int i = 0;
		int j = 0;
		
		while (j < len)
		{
			while (j < len && a[j] == ' ') j++; // skip leading spaces
			while (j < len && a[j] != ' ') a[i++] = a[j++]; // keep non-spaces
			while (j < len && a[j] == ' ') j++; // skip trailing spaces
			if (j < len) a[i++] = ' ';  // keep only one space
		}
		
		return new String(a).substring(0, i);
	}
}