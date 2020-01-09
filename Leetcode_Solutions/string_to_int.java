// https://leetcode.com/problems/string-to-integer-atoi
public class Solution 
{
	public int myAtoi(String str) 
    {
		if (str.length() == 0) return 0;
        int result = 0;
		int sign = 1;
        
        int i = 0;
        int len = str.length();
        
        while(i < len && str.charAt(i) == ' ')
            i++;
        
		if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+'))
			sign = str.charAt(i++) == '+' ? 1 : -1;
        
		for (; i < len; ++i) 
        {
			int tmp = str.charAt(i) - '0';
			if (tmp < 0 || tmp > 9)
				break;
			if (result > Integer.MAX_VALUE / 10
				|| (result == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp))
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			else
                result = result * 10 + tmp;
		}
		return sign * result;
	}
}
