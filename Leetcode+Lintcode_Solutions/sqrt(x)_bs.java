class Solution {
	public int mySqrt(int x) {
		if(x == 0 || x ==1) return x;
		
		int start = 1;
		int end = x;
		int mid = start + (end-start)/2;
		while(start <= end)
		{
			mid = start + (end-start)/2;
			if(mid <= (x/mid))
			{
				start = mid +1;
				// if mid*mid < x but (mid+1)^2 >x then return mid
				if(start > x/start)
				{
					return mid;
				}
			}
			else
			{
				end = mid - 1;
			}
		}
		return -1;
	}
}