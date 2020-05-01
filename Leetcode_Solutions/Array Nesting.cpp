// Time: O(n) Space: O(1)
class Solution {
public:
	int arrayNesting(vector<int>& nums) 
	{
		int max_len = 0;
		int count = 0;
		
		for (int i = 0; i < nums.size(); i++)
		{
			if (nums[i] == -1) // if visited, no need to consider
				continue;
			
			count = 0;
			
			for (int j = i; nums[j] != -1; )
			{
				count++;
				int temp = nums[j];
				nums[j] = -1; // visited: -1
				j = temp;
			}
			
			max_len = max(max_len, count);
		}
		
		return max_len;
	}
};