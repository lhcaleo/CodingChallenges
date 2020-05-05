// Time: O(n^2) Space: O(1)
// Brute Force
// if we rotate A by s, then check that A[s] == B[0], A[s+1] == B[1], ...
class Solution 
{
	public boolean rotateString(String A, String B) 
	{
		if (A == null || B == null || A.length() != B.length())
			return false;
		
		if (A.length() == 0)
			return true;
		
		for (int i = 0; i < A.length(); i++)
		{

			boolean equal = true;
			
			for (int j = 0; j < A.length() && equal; j++)
			{
				if (B.charAt(j) != A.charAt((i+j) % A.length()))
					equal = false;
			}
			// if each char at A and B is equal, then rotated is checked
			// otherwise, check new s
			if (equal)
				return true;
		}
		
		return false;     
	}
}


// Time: O(n^2) Space: O(N)
// if B can be found in (A + A), then rotated is true
// A = 'abcde' B = 'bcdea' A + A = 'abcdeabcde'
class Solution 
{
	public boolean rotateString(String A, String B) 
	{
		return A.length() == B.length() && (A + A).contains(B);
	}
}