// Reverse by swapping
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse String.
// Memory Usage: 52.3 MB, less than 7.10% of Java online submissions for Reverse String.
class reverseString {
	public void reverseString(char[] s) 
	{
		for(int i = 0, j = s.length-1; i < j; i++,j--)
		{
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}
}


// if input is String s
//public static String reverseString(String s) {
//	return new StringBuffer(s).reverse().toString();
//}