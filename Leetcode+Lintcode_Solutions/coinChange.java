// https://leetcode.com/problems/coin-change/
// Dynamic Programming
// Time: O(m*n)  m: amount n: number of type of coins
// Space: O(m)

class Solution {
	public int coinChange(int[] coins, int amount) 
	{
		// 0.....amount: [amount+1]
		int[] f = new int[amount + 1];
		// number of kinds of coins
		int num_coins = coins.length; 
		
		// initialization
		f[0] = 0;
			

		// f[1], f[2], ..., f[amount]
		for(int i = 1; i <= amount; i++)
		{
			f[i] = Integer.MAX_VALUE;
			// last coin coins[j]
			// f[i] = min{f[i-coins[0]]+1, ..., f[i-coins[n-1]]+1}
			for(int j = 0; j < num_coins; j++)
			{
				if(i >= coins[j] && f[i-coins[j]] != Integer.MAX_VALUE)
				{
					f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
				}
			}
		}
		
		// if the amount cannot be made up
		if(f[amount] == Integer.MAX_VALUE)
		{
			f[amount] = -1;
		}
		
		return f[amount];
	}
}