/*
https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
Longest Common Subsequence
*/

// { Driver Code Starts
#include<bits/stdc++.h>
const int mod=1e9+7;
using namespace std;

 // } Driver Code Ends
// function to find longest common subsequence

class Solution
{
    public:
    vector<vector<int>> dp;
    //Function to find the length of longest common subsequence in two strings.
    int lcs(int x, int y, string s1, string s2)
    {
        dp.resize(x+1, vector<int>(y+1, -1));
        
        if(!x || !y) return 0;
        
        // return lcsDP(x, y, s1, s2);
        
        for(int i=0; i<=x; i++)
        {
            for(int j=0; j<=y; j++)
            {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else if(s1[i-1] == s2[j-1])
                    dp[i][j] = dp[i-1][j-1] +1;
                else
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[x][y];
    }//end
    
    int lcsDP(int m, int n, string &X, string &Y)
    {
        if(!m || !n)
            return 0;
            
        if(X[m-1] == Y[n-1])
            return dp[m][n]=1 + lcsDP(m-1, n-1, X, Y);
        else if(dp[m][n] != -1)
            return dp[m][n];
        else
            return (dp[m][n] = max(lcsDP(m-1, n, X, Y), lcsDP(m, n-1, X, Y)));
    }//end
    
    int lcsRecursive(int x, int y, string s1, string s2)
    {
        if(!x || !y)
            return 0;
        if(s1[x-1]==s2[y-1])
            return (1 + lcs(x-1, y-1, s1, s2));
        else
            return max(lcs(x-1, y, s1, s2), lcs(x, y-1, s1, s2));
    }//end
};


// { Driver Code Starts.
int main()
{
    int t,n,k,x,y;
    cin>>t;
    while(t--)
    {
        cin>>x>>y;          // Take size of both the strings as input
        string s1,s2;
        cin>>s1>>s2;        // Take both the string as input
        Solution ob;
        cout << ob.lcs(x, y, s1, s2) << endl;
    }
    return 0;
}
  // } Driver Code Ends