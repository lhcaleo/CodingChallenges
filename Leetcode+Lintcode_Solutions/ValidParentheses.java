// https://leetcode.com/problems/valid-parentheses/submissions/
// O(n) time. O(n) memory for stack


class Solution {
	public boolean isValid(String s) {
		if(s.length() % 2 != 0) return false;
		
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				if (c == ')') {
					if ('(' != stack.pop())
						return false;
				} else if (c == ']') {
					if ('[' != stack.pop())
						return false;
				} else if (c == '}') {
					if ('{' != stack.pop())
						return false;
				}
			}
		}
		return stack.isEmpty();
	}
}