// https://leetcode.com/problems/roman-to-integer/
// concepts: java string, char array, switch statement

class Solution 
{
	public int romanToInt(String s) 
	{
		char[] str = s.toCharArray();
		int num = 0;
		char c = ' ';
		for(int i = 0; i < str.length; i++)
		{
			c = str[i];
			switch(c)
			{
				case 'I': 
					if(i+1 < str.length && str[i+1] == 'V')
					{
						num += 4;
						i++;
					}
					else if(i+1 <str.length && str[i+1] == 'X')
					{
						num += 9;
						i++;
					}
					else num++;
					break;
				case 'V': 
					num += 5;
					break;
				case 'X': 
					if(i+1 <str.length && str[i+1] == 'L')
					{
						num += 40;
						i++;
					}
					else if(i+1 <str.length && str[i+1] == 'C')
					{
						num += 90;
						i++;
					}
					else num += 10;
					break;
				case 'L': 
					num += 50;
					break;
				case 'C': 
					if(i+1 <str.length && str[i+1] == 'D')
					{
						num += 400;
						i++;
					}
					else if(i+1 <str.length && str[i+1] == 'M')
					{
						num += 900;
						i++;
					}
					else num += 100;
					break;
				case 'D': 
					num += 500;
					break;
				case 'M': 
					num += 1000;
					break;
			}
		}
		return num;
	}
}
