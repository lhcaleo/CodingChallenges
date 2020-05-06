// Time: O(n) Space: O(1)
class Solution 
{
	public boolean isPalindrome(int x) 
	{
		if (x < 0)
			return false;
		if (x == 0)
			return true;
		
		int copy_x = x;
		int reverse = 0;
		
		// reverse the integer x
		while (copy_x != 0)
		{
			int digit = copy_x % 10;
			reverse = reverse * 10 + digit;
			copy_x = copy_x / 10;
		}
		
		return x == reverse;
	}
}