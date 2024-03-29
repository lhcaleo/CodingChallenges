// https://leetcode.com/problems/valid-parentheses/submissions/
// Time: O(n) Space: O(n)
class Solution 
{
	public boolean isValid(String s) 
	{
		if (s.length() % 2 != 0)
			return false;
		
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < s.length(); i++)
		{
			char c = s.charAt(i);
			
			if (c == '(' || c == '{' || c == '[')
			{
				stack.push(c);
			}
			else
			{
				if (stack.isEmpty())
					return false;
				else if (c == ')')
				{
					if (stack.pop() != '(')
						return false;
				}
				else if (c == '}')
				{
					if (stack.pop() != '{')
						return false;
				}
				else if (c == ']')
				{
					if (stack.pop() != '[')
						return false;
				}
			}
		}
		
		return stack.isEmpty();
	}
}