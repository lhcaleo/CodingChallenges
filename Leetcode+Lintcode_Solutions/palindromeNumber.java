// https://leetcode.com/problems/palindrome-number/

class Solution {
	public boolean isPalindrome(int x) {
		// negative numbers are not palindrome
		if(x<0) return false;
		if(x==0) return true;
		int copy = x;
		int rev = 0;
		// reverse the integer
		while(copy!=0)
		{
			int digit = copy%10;
			rev = rev * 10 + digit;
			copy /= 10;
		}
		return rev == x;
	}
}