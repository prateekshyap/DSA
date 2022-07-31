/*
https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1/#
Painting the Fence 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
#include<stdio.h>
#include<math.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    const int mod = 1e9 + 7;
    
    long long countWays(int n, int k){
        
        if(n==1)
            return k;
        if(n==2)
            return k*k;
        if(n==3)
            return k*k*k-k;
        
        vector<long long int> dp(n+1, 0);
        // dp[0] = 0;
        dp[1] = k;
        dp[2] = k*k;
        
        for(int i=3; i<=n; i++)
        {
            dp[i] = ((dp[i-1] + dp[i-2])*(k-1))%mod;
        }
        
        return dp[n];
    }
    
    /*//TLE
    vector<vector<vector<int>>> memo;
    
    long long countWays(int n, int k){
        
        memo.resize(n+1, vector<vector<int>>(k+1, vector<int>(k+1, -1)));
        
        return solve(0, 0, 0, n, k);
    }
    
    long long solve(int idx, int last, int seclast, int n, int k)
    {
        // if(n==0)
        //     return 0;
        // if(n==1)
        //     return k;
        if(idx == n)
            return memo[idx][last][seclast] = 1;
        
        if(memo[idx][last][seclast] != -1)
            memo[idx][last][seclast];
            
        long long cnt=0;
        
        for(int col=1; col<=k; col++)
        {
            if( col == last and col == seclast)
                continue;
            cnt+= solve(idx+1, col, last, n, k)%mod;
        }
        
        return memo[idx][last][seclast] = cnt%mod;
    }
    */
};

// { Driver Code Starts.

int main()
{
	
	int t;
	cin>>t;
	while(t--)
	{
		int n,k;
		cin>>n>>k;
		Solution ob;
		cout<<ob.countWays(n,k)<<endl;
	}
	return 0;
}  // } Driver Code Ends