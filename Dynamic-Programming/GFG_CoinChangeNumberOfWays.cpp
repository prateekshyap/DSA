/*
https://practice.geeksforgeeks.org/problems/coin-change2448/1/#
Coin Change 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    int arrsize=0;
    long long int count(int S[], int m, int n) {
        arrsize = m;
        // vector<vector<long long int>> memo(arrsize+1, vector<long long int>(n+1, -1));
        // return solve(0, n, S, memo);
        vector<long long int> tab(n+1, 0);
        tab[0] = 1;
        
        for(int ci=0; ci<arrsize; ci++)
        {
            for(int amt=S[ci]; amt<=n; amt++)
            {
                tab[amt] = tab[amt] + tab[amt-S[ci]];
            }
        }
        return tab[n];
    }
    
    long long int solve(int idx, int amt, int *s, vector<vector<long long int>>& memo)
    {
        if(amt == 0)
            return memo[idx][amt]=1;
        
        if(memo[idx][amt] != -1)
            return memo[idx][amt];
        
        long long int cnt=0;
        for(int i=idx; i<arrsize; i++)
        {
            if(s[i] <= amt)
                cnt+= solve(i, amt-s[i], s, memo);
        }
    
        return memo[idx][amt]=cnt;    
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        int arr[m];
        for (int i = 0; i < m; i++) cin >> arr[i];
        Solution ob;
        cout << ob.count(arr, m, n) << endl;
    }

    return 0;
}  // } Driver Code Ends