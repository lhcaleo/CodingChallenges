// Time: O(n) Space: O(n)
// One pass solution with 2 hashmap
class Solution {
public:
	int findShortestSubArray(vector<int>& nums) 
	{
		unordered_map<int, int> count;
		unordered_map<int, int> first;
		
		int res = 0;
		int degree = 0;
		
		for (int i = 0; i < nums.size(); i++) 
		{
			// record each num's first occurence index
			if (first.count(nums[i]) == 0)
			{
				first[nums[i]] = i;
			} 
			// if num has max frequency, update degree and res
			if (++count[nums[i]] > degree) 
			{
				degree = count[nums[i]];
				res = i - first[nums[i]] + 1;
			} 
			// if num is one of the numbers that has max frequency, 
			// take min of current res and new res (want smallest possible length)
			else if (count[nums[i]] == degree)
			{
				res = min(res, i - first[nums[i]] + 1);
			}
		}
		
		return res;
	}
};