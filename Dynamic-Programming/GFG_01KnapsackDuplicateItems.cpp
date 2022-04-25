// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

/*
https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
Knapsack with duplicate items
*/
class Solution{
public:
    int knapSack(int N, int W, int val[], int wt[])
    {
        int dp[W+1] = {0};
        
        // for(int w=W; w>=0; w--)
        for(int w=1; w<=W; w++)
        {
          for(int i=0; i<N; i++)
          {
              if(wt[i] <= w)
                dp[w] = max(dp[w], val[i]+dp[w-wt[i]]);
          }
        }
        return dp[W];
    }// end
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