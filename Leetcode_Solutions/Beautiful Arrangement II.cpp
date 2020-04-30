// Time: O(n) Space: O(n)
// if k = n - 1, pick numbers interleavingly from head and tail,
// otherwise, simply lay out the rest (i, j) incremental order (all diff is 1)
#include <vector>
using namespace std;

class Solution {
public:
	vector<int> constructArray(int n, int k) {
		vector<int> res;
		
		int i = 1;
		int j = n;
		
		while (i <= j)
		{
			if (k > 1 && k % 2 == 1)
			{
				res.push_back(i++);
				k--;
			}
			else if (k > 1 && k % 2 == 0)
			{
				res.push_back(j--);
				k--;
			}
			else
			{
				res.push_back(i++);
			}
		}
		
		return res;
	}
};