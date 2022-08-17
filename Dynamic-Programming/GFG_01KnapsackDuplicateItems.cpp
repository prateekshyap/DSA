
/*
https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
Knapsack with duplicate items
*/

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        // vector<vector<int>> dp(N+1, vector<int>(W+1, -1));
        // return knapSackRec(N, W, dp, wt, val);
        
         
        // int dp1[W+1] = {0};
        // // for(int w=W; w>=0; w--)
        // for(int w=1; w<=W; w++)
        // {
        //   for(int i=0; i<N; i++)
        //   {
        //       if(wt[i] <= w)
        //         dp1[w] = max(dp1[w], val[i]+dp1[w-wt[i]]);
        //     cout<<dp1[w]<<" ";
        //   }
        // }
        // cout<<endl;
        
        int dp[W+1] = {0};
       
        for(int i=0; i<N; i++)
        {
          for(int w=wt[i]; w<=W; w++)
          {
            //   if(wt[i] <= w)
                dp[w] = max(dp[w], val[i]+dp[w-wt[i]]);
                // cout<<dp[w]<<" ";
          }
        }
        return dp[W];
    }
    
    int knapSackRec(int idx, int W, vector<vector<int>>& dp, int *wt, int *val)
    {
        if(idx <= 0)
            return 0;
        if(W == 0)
            return 0;
        if(dp[idx][W] != -1)
            return dp[idx][W];
        
        if(wt[idx-1] > W)
            return dp[idx][W] = knapSackRec(idx-1, W, dp, wt, val);
        else
            return dp[idx][W] = max(knapSackRec(idx-1, W, dp, wt, val), knapSackRec(idx, W-wt[idx-1], dp, wt, val)+val[idx-1]);
        
    }
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N, W;
        cin>>N>>W;
        int val[N], wt[N];
        for(int i = 0;i < N;i++)
            cin>>val[i];
        for(int i = 0;i < N;i++)
            cin>>wt[i];
        
        Solution ob;
        cout<<ob.knapSack(N, W, val, wt)<<endl;
    }
    return 0;
}  // } Driver Code Ends