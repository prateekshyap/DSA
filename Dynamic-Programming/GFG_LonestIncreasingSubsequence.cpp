/*
https://practice.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1#
Longest Increasing Subsequence 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution
{
    public:
    //Function to find length of longest increasing subsequence.
    int longestSubsequence_1(int n, int a[])
    {
       vector<int> dp(n+1, 1);
       for(int i=1; i<n; i++)
       {
           for(int j=0; j<i; j++)
           {
               if(a[j]<a[i] and dp[i] < dp[j]+1)
                  dp[i] = dp[j]+1;
           }
        //   cout<<dp[i]<<" ";
       }
       
       return *max_element(dp.begin(), dp.end());
    }
    
    int longestSubsequence(int n, int a[])
    {
       vector<int> dp;
       for(int i=0; i<n; i++)
       {
           int idx = lower_bound(dp.begin(), dp.end(), a[i]) - dp.begin();
           if(idx == dp.size())
              dp.push_back(a[i]);
           else
              dp[idx] = a[i];
       }
       
       return dp.size();
    }
};

// { Driver Code Starts.
int main()
{
    //taking total testcases
    int t,n;
    cin>>t;
    while(t--)
    {
        //taking size of array
        cin>>n;
        int a[n];
        
        //inserting elements to the array
        for(int i=0;i<n;i++)
            cin>>a[i];
        Solution ob;
        //calling method longestSubsequence()
        cout << ob.longestSubsequence(n, a) << endl;
    }
}
  // } Driver Code Ends