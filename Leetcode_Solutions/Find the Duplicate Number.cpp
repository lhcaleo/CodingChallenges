// Time: n O(log n) for loop within binary search
// Space: O(1)
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
	int findDuplicate(vector<int>& nums) {
		int left = 0;
		int right = nums.size() - 1;
		
		while (left < right)
		{
			int mid = left + (right - left) / 2;
			int counter = 0;
			
			// count # of numbers <= middle number of the range [1, n] 
			for (int num: nums)
			{
				if (num <= mid)
					counter++;
			}
			
			// duplicate is in the left portion [left, mid],
			// otherwise, in [mid + 1, right]
			if (counter > mid)
				right = mid;
			else
				left = mid + 1;
		}
		
		return left;
	}
};