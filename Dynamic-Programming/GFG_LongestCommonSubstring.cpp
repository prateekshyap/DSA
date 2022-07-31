/*
https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#
Longest Common Substring 

https://binarysearch.com/problems/Longest-Common-Substring
*/
// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    
    vector<vector<int>> dp;
    int mxl=-1;
    
    int longestCommonSubstr(string S1, string S2, int n, int m)
    {
        dp.resize(n+1, vector<int>(m+1, -1));
        lcsRec(S1, S2, n, m);
        return mxl;
        
        // Top-Down
        vector<vector<int>> tab(n+1, vector<int>(m+1, 0));
        
        int maxLen = 0;
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=m; j++)
            {
                if(S1[i-1] == S2[j-1])
                {    
                    tab[i][j] = 1 + tab[i-1][j-1];
                    if(tab[i][j] > maxLen)
                        maxLen = tab[i][j];
                }
                // else
                //     tab[i][j] = 0;
            }
        }
        
        return maxLen;
    }// end
    
    int longestCommonSubstr1(string S1, string S2, int n, int m)
    {
        
        // Top-Down
        vector<int> tab(m+1, 0);
        
        int maxLen = 0;
        
        for(int i=1; i<=n; i++)
        {
            // cout<<S1[i-1]<<" -- ";
            // for(int j=1; j<=m; j++)
            for(int j=m; j>0; j--)
            {
                // cout<<S2[j-1]<<endl;
                if(S1[i-1] == S2[j-1])
                {    
                    tab[j] = 1 + tab[j-1];
                    if(tab[j] > maxLen)
                        maxLen = tab[j];
                }
                else
                    tab[j] = 0;
                    
                
                
            }
            // for(int x: tab)
            //         cout<<x<<' ';
            // cout<<endl;
        }
        
        return maxLen;
    }// end
    
    // int lcsRec(string &X, string &Y, int i, int j)
    // {
    //     if(i<=0 || j<=0) return dp[i][j] = 0;
        
    //     if(dp[i][j] != -1)
    //         return dp[i][j];
            
        
    //     if(X[i-1] == Y[j-1])
    //      {   
    //             //  cout<<X[i-1]<<" -- "<<Y[j-1]<<endl;
    //          dp[i][j] = 1+lcsRec(X,Y, i-1, j-1);
    //          if(dp[i][j] > mxl)
    //             mxl = dp[i][j];
    //      }
    //      else
    //      {   
    //         //  cout<<X[i-1]<<" != "<<Y[j-1]<<endl;
    //         if(lcsRec(X,Y, i-1, j) != 0)
    //             dp[i][j] = lcsRec(X,Y, i-1, j);
    //         else if(lcsRec(X,Y, i, j-1) != 0)
    //             dp[i][j] = lcsRec(X,Y, i, j-1);
    //         //  dp[i][j] = max(lcsRec(X,Y, i-1, j), lcsRec(X,Y, i, j-1))-1;
        
    //         // dp[i-1][j] = lcsRec(X,Y, i-1, j);
    //         // dp[i][j-1] =  lcsRec(X,Y, i, j-1);
    //      }
        
    //     return dp[i][j];
    // }
};

// { Driver Code Starts.

int main()
{
    int t; cin >> t;
    while (t--)
    {
        int n, m; cin >> n >> m;
        string s1, s2;
        cin >> s1 >> s2;
        Solution ob;

        cout << ob.longestCommonSubstr (s1, s2, n, m) << endl;
    }
}
// Contributed By: Pranay Bansal
  // } Driver Code Ends
  
  
  
//BS

int solve_1(string s0, string s1) {
   int ans=0;
   int n0 = s0.size();
   int n1 = s1.size();
   int dp[n0+1][n1+1];

   for(int i=0; i<=n0; i++)
   {
       for(int j=0; j<=n1; j++)
       {
           if(i==0 || j==0)
             dp[i][j] = 0;
           else if(s0[i-1]==s1[j-1])
            {    
                dp[i][j] = dp[i-1][j-1]+1;
                if(ans < dp[i][j])
                    ans = dp[i][j];
                // ans = max(ans, dp[i][j]);
            }
            else
                dp[i][j] = 0;
            
       }
   }

   return ans; 
}//

int solve(string s0, string s1) {
    int ans = 0;
    int n0 = s0.size();
    int n1 = s1.size();
    vector<int> dp(n1 + 1, 0);
    for(int i = 1; i <= n0; i++) {
        for(int j = n1; j >= 1; j--) 
        {
            if(s0[i-1] == s1[j-1]) 
            {
                dp[j] = dp[j-1] + 1;
                if(ans < dp[j])
                    ans = dp[j];
            }
            else dp[j] = 0;
        }
        // ans = max(ans, *max_element(dp.begin(), dp.end()));
    }
    return ans;
}

static int MOD = 1e9 + 7, BASE = 51;
bool hasCommon(string &s0, string &s1, int len) {
    // Return true for finding common substring for length `0`.
    if (!len) return true;

    // Stores all hashes encountered for strings of length `len` in s0.
    unordered_set<int> encountered;
    long hash = 0, pow = 1;

    // pow(BASE,len-1) required for rolling hash.
    for (int i = 0; i < len - 1; i++) pow = (pow * BASE) % MOD;

    // Calculate and store all hashes of strings of length len from s0.
    for (int i = 0; i < s0.length(); i++) {
        // Remove hash created by the character moving out of the window.
        if (i >= len) hash = (((hash - (s0[i - len] - 'a' + 1) * pow) % MOD) + MOD) % MOD;
        hash = (hash * BASE) % MOD;
        hash = (hash + s0[i] - 'a' + 1) % MOD;
        if (i >= len - 1) encountered.insert(hash);
    }
    hash = 0;

    // Calculate all hashes of strings of length `len` in s1.
    // Return true if any hash exist in the set `encountered`.
    for (int i = 0; i < s1.length(); i++) {
        // Remove hash created by the character moving out of the window.
        if (i >= len) hash = ((hash - (((s1[i - len] - 'a' + 1) * pow) % MOD)) + MOD) % MOD;
        hash = (hash * BASE) % MOD;
        hash = (hash + s1[i] - 'a' + 1) % MOD;
        if (i >= len - 1 && encountered.count(hash)) return true;
    }
    // No hashes found in s1 same as s0.
    return false;
}
int solve_3(string s0, string s1) {
    if (s1.length() < s0.length()) s1.swap(s0);
    int i = 0, j = s0.length() + 1, mid;
    // Basic binary search template for finding maxium length
    // of common substring between 0 and min(s0.length(),s1.length()).
    while (i < j) {
        mid = (i + j) / 2;
        if (hasCommon(s0, s1, mid))
            i = mid + 1;
        else
            j = mid;
    }
    return i - 1;
}
