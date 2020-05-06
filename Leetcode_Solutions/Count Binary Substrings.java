// Time: O(n) Space: O(1)
// kind like two pointer
// since consecutive, no cases like 0101, 1001
class Solution 
{
	public int countBinarySubstrings(String s) 
	{
		int prev_len = 0;
		int current_len = 1;
		int count = 0;
		
		for (int i = 1; i < s.length(); i++)
		{
			// check if current num is equal to previous num
			// if so, the count of current num ++
			if (s.charAt(i - 1) == s.charAt(i))
				current_len++;
			// if not, current num becomes previous num
			else 
			{
				prev_len = current_len;
				// reset current length back to 1
				current_len = 1;
			}
			// = : 0011  > : 00111
			if (prev_len >= current_len)
				count++;
		}
		
		return count;
	}
}

/*
index    01234
example [00110]
i = 1, curr++ = 2
i = 2, prev = curr = 2, curr = 1  (prev >= curr) count++ = 1
i = 3, curr++ = 2, (prev >= curr) count++ = 2
i = 4, prev = curr = 2, curr = 1, (prev >= curr) count++ = 3
*/