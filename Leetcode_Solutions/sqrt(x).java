// Brute force solution
// sqrt(x).java
// Created by HAO on 2019-10-12.
class Solution {
	public int mySqrt(int x) {
		int i = 1;
		while(true)
		{
			// use i > x/i instead of i*i > x to avoid overflow
			if(i  > (x/i) ) return i-1;
			i++;
		}  
	}
}