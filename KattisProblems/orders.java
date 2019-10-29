import java.util.*;
// https://open.kattis.com/problems/orders

public class orders
{
	public static void main(String[] args) 
	{

		// Read in lines
		Scanner scanner = new Scanner(System.in);
		int n =  scanner.nextInt();       // # of items on menu
		int[] itemCosts = new int[n];     // cost of each item
		for (int i = 0; i < n; i++) { itemCosts[i] = scanner.nextInt();}
		// initialize with -2 expect index 0
		int[] dp = new int[32000];
		Arrays.fill(dp, -2);
		dp[0] = 0;
		
		for(int i = 0; i < n; i ++)
		{
			for(int j = 0; j < 30000; j++)
			{
				if(dp[j] >= 0)
				{
					if(dp[j + itemCosts[i]] == -2) dp[j + itemCosts[i]] = i + 1;
					else dp[j + itemCosts[i]] = -1; 
				} 
				
				if(dp[j] == -1) dp[j + itemCosts[i]] = -1;
			}
		}	
		
		int m = scanner.nextInt();        // # of orders placed
		// ginve cost of each order, find its corresponding options
		for(int i = 0; i < m; i++)
		{
			int target = scanner.nextInt();
			if (dp[target] == -1) System.out.println("Ambiguous");
			else if (dp[target] == -2) System.out.println("Impossible");
			else
			{
				PriorityQueue<Integer> queue = new PriorityQueue<>();
				while(target > 0)
				{
					queue.add(dp[target]);
					target -= itemCosts[dp[target] - 1];
				}
				while (!queue.isEmpty()) 
				{
					System.out.print(queue.poll() + " ");
				}
			}
		}	
	}
}