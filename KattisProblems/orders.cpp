#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

// [desired total cost][using only items up to and including this index]
// max 100 items on menu
// max 50$ of an order
int dp[50][100], used_item[50][100];


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
	for (int s = 1; s <= 50; s++)  // s = 1, 2, ..., 50
	{
		int ways = 0;
		int ui = 0;
		
		for (int n = 0; n < N; n++)   // n = 0, 1, 2
		{
			cout << "s = " << s << " n = " << n << "   items[n] = '" << items[n] << "'" << endl;
			if (s >= items[n])        // if 's' is greater than items[n]'s price
			{
				int tdp = dp[s - items[n]][n];
				cout << "tdp = " << tdp << endl;
				if (tdp == 1) 
				{
					ui = n;
				}
				ways += tdp;
				cout << "ways = " << ways << endl;
				if (ways > 2) ways = 2;
			}
			dp[s][n] = ways;
			cout << "s = " << s << " n = " << n << "   dp[s][n] = '" << dp[s][n] << "'\n" << endl;
			used_item[s][n] = ui;
		}
		cout << "---------------------------" << endl;
	}

	int M;
	cin >> M;
	for (int m = 0; m < M; m++) 
	{
		int totalcost;
		cin >> totalcost;
		int poss = dp[totalcost][N-1];
		if (poss == 0) 
		{
			cout << "Impossible\n";
		} 
		else if (poss > 1) 
		{
			cout << "Ambiguous\n";
		} 
		else 
		{
			vector<int> stuff;
			int tc = totalcost, n = N-1;
			while (tc) 
			{
				n = used_item[tc][n];
				stuff.push_back(n + 1);
				tc -= items[n];
			}
			sort(stuff.begin(), stuff.end());
			for (int i = 0; i < stuff.size(); i++) 
			{
				if (i) cout << ' ';
				cout << stuff[i];
			}
			cout << endl;
		}
	}
}
