/*
https://practice.geeksforgeeks.org/problems/ncr1019/1#
nCr 
*/

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    const int mod = 1e9+7;
    
    /* 
    // TLE
    // int failed in 1st case 15 3
    // long failed in 11th case 778 116
    int nCr(int n, int r){
        
        if(r>n)
            return 0;
        
        vector<long> fac(n+1, 0);
        fac[0] = 1;
        fac[1] = 1;
        for(int i=2; i<=n; i++)
        {
            fac[i] = fac[i-1]*i;
            // cout<<fac[i]<<" ";
        }
        
        long ans = fac[n]/((fac[n-r])*(fac[r])); 
        
        return ans;
    }
    */
    
    
    int nCr(int n, int r){
        
        if(r>n)  return 0;
        if (r > n - r) // Optimization for the cases when r is large
            r = n - r;
        vector<vector<int>> memo(n+1, vector<int>(r+1, -1));
        return solve(n, r, memo);
    }
    
    int solve(int n, int r, vector<vector<int>>& memo)
    {
        if(n<r) return memo[n][r] = 0;
        if(n==r || r==0) return memo[n][r] = 1;
        if(r==1) return memo[n][r] = n;
        
        if(memo[n][r] != -1)
            return memo[n][r];
            
        return memo[n][r] = (solve(n-1, r-1, memo) + solve(n-1, r, memo))%mod;
    }
    
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, r;
        cin>>n>>r;
        
        Solution ob;
        cout<<ob.nCr(n, r)<<endl;
    }
    return 0;
}  // } Driver Code Ends