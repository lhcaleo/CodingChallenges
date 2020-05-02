// Time: O(n)  Space: O(1)
class Solution {
public:
	int maxChunksToSorted(vector<int>& arr) 
	{
		if (arr.empty())
			return 0;
		
		int res = 0;
		int right = arr[0];
		
		for (int i = 0; i < arr.size(); i++)
		{
			right = max(right, arr[i]);
			
			// numbers range from 0 to arr.length - 1
			// if max = index i, then max can come back to its position 
			// we must put max number at its right position
			if (right == i)
				res++;
		}
		
		return res;
	}
};