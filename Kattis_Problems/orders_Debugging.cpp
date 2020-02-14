#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

// [desired total cost][using only items up to and including this index]
// max 100 items on menu
// max 30000$ of an order
int dp[30000][100], used_item[30000][100];


//  3
//  4 5 8
//  3
//  11 13 14
int main() 
{
	int N, items[100];
	cin >> N;
	
	// N = 3 items 
	for (int n = 0; n < N; n++) dp[0][n] = 1;    // intialize all 100 index to 1
	for (int n = 0; n < N; n++) cin >> items[n]; // read in n = 3 item costs
	
	
	// items[i] stores the price of item i
	for (int s = 1; s <= 30000; s++)  // s = 1, 2, ..., 30000   order cost
	{
		int ways = 0;
		int ui = 0;
		
		for (int n = 0; n < N; n++)   // n = 0, 1, 2
		{
			cout << "s = " << s << " n = " << n << "   items[" << n << "] = '" << items[n] << "'" << endl;
			if (s >= items[n])        // if 's' is greater than items[n]'s price
			{
				int tdp = dp[s - items[n]][n];
				cout << "tdp = dp[" << s << "-" << items[n] <<"][" << n << "] = " << tdp << endl;
				if (tdp == 1) 
				{
					ui = n;
				}
				ways = ways + tdp; // number of ways to reach the order cost
				cout << "ways = " << ways << endl;
				if (ways > 2) ways = 2;
			}
			dp[s][n] = ways;
			cout << "dp[" << s << "][" << n << "] = " << dp[s][n] << endl;
			used_item[s][n] = ui;
			cout << "used_item[" << s << "][" << n << "] = "  << used_item[s][n] << "\n" << endl;
		}
		cout << "---------------------------" << endl;
	}

	int M;
	cin >> M;
	for (int m = 0; m < M; m++) 
	{
		int totalcost;
		cin >> totalcost;
		cout << "totalcost = " << totalcost << ", N-1 = " << N-1 << endl;
		int possibleOrders = dp[totalcost][N-1];   // dp[14][2]
		cout << "possibleOrders = " << possibleOrders << endl;
		if (possibleOrders == 0) 
		{
			cout << "Impossible" << endl;   // no order possibleOrdersible
		} 
		else if (possibleOrders > 1) 
		{
			cout << "Ambiguous" << endl;   // more than 1 order
		} 
		else                         // one unique order giving the specified total cost
		{
			vector<int> result;
			int tc = totalcost, n = N-1;
			while (tc) 
			{
				n = used_item[tc][n];
				result.push_back(n + 1);
				tc -= items[n];
			}
			sort(result.begin(), result.end());
			for (int i = 0; i < result.size(); i++) 
			{
				if (i) cout << ' ';
				cout << result[i];
			}
			cout << endl;
		}
	}
}
