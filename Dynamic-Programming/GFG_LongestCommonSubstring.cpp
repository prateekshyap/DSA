/*
https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1#
Longest Common Substring 
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