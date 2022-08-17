/*
Get Minimum Squares
https://practice.geeksforgeeks.org/problems/get-minimum-squares0538/1
some variation of coin change
*/

class Solution{
	public:
	int MinSquares(int n)
	{
	    if(n==1) return 1;
	   // int sqroot = sqrt(n);
	   // vector<int> coins(sqroot+1);
	   // for(int i=0; i<=sqroot; i++)
	   //     coins[i] = i*i;
	   // vector<int> dp(n+1, 1e9);
	   // dp[0] = 0; 
	   // for(int cv: coins)
	   // {
	   //     for(int x=cv; x<=n; x++)
	   //     {
	   //        dp[x] = min(dp[x], 1+dp[x-cv]);
	   //     }
	   // }
	   
	    int sqroot = sqrt(n);
	    vector<int> dp(n+1, 1e9);
	    dp[0] = 0; 
	    for(int i=1; i<=sqroot; i++)
	    {
	        int cv = i*i;
	        for(int x=cv; x<=n; x++)
	        {
	           dp[x] = min(dp[x], 1+dp[x-cv]);
	        }
	    }
	    return dp[n];
	}
};