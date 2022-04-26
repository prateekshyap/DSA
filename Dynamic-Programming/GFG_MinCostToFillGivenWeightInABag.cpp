/*
https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1#
Minimum cost to fill given weight in a bag 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
#include <bits/stdc++.h>
using namespace std;
//Position this line where user code will be pasted.

class Solution{
		

	public:
// 	vector<vector<int>> dp;
	int minimumCost(int cost[], int N, int W) 
	{ 
	    // variation of knapsack with duplicate items
        // dp.resize(N+1, vector<int>(W+1, -1));
        // int dp[W+1] = {0};
        vector<int> dp(W+1, INT_MAX);
        dp[0] = 0;
        
        for(int w=1; w<=W; w++)
        {
            for(int i=1; i<=N; i++)
            {
                if(i<=w && cost[i-1]!=-1 && dp[w-i]!=INT_MAX)
                {
                    dp[w] = min(dp[w], cost[i-1]+dp[w-i]);
                }
            }
        }
        
        return dp[W] == INT_MAX ? -1 : dp[W]; 
	} // end
	
	
};


// { Driver Code Starts.
int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, w;
        cin >> n >> w;

        int a[n];

        for(int i = 0; i < n; i++)
        	cin >> a[i];

       

	    Solution ob;
	    cout << ob.minimumCost(a, n, w) << "\n";
	     
    }
    return 0;
}  // } Driver Code Ends