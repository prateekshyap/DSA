/*
https://leetcode.com/problems/shortest-common-supersequence/
1092. Shortest Common Supersequence

*/

class Solution {
public:
    vector<vector<int>> memo;
    string shortestCommonSupersequence(string str1, string str2) {
        int n = str1.size(), m = str2.size();
        // memo.resize(n+1, vector<int>(m+1, -1));
        // int len=LCSRec(n,m, str1, str2);
        // return n+m-len;
        vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        for(int i=1; i<=n; ++i)
        {
            for(int j=1; j<=m; j++)
            {
                if(str1[i-1] == str2[j-1])
                     dp[i][j] = 1 + dp[i-1][j-1] ;
                else
                     dp[i][j] = max(dp[i][j-1],dp[i-1][j]);
            }
        }
        // cout<<'-'<<" "<<'-'<<" ";for(int j=0; j<=m ; j++) cout<<str2[j]<<" "; cout<<endl;
        // for(int i=0; i<=n; i++) {  if(i>=1)cout<<str1[i-1]<<" ";else cout<<'-'<<" ";for(int j=0; j<=m ; j++) cout<<dp[i][j]<<" "; cout<<endl; }
        string ans;
        int i=n, j=m;
        while(i>0 and j>0)
        {
            if(str1[i-1] == str2[j-1])
            {
                ans += str1[i-1];
                i--;  j--;
            }
            else if(dp[i-1][j] > dp[i][j-1])
            {
                ans += str1[i-1];
                i--;
            }
            else
            {
                ans += str2[j-1];
                j--;
            }
        }
        
        while(i>0){
            ans += str1[i-1];
                i--;
        }
        
         while(j>0){
            ans += str2[j-1];
                j--;
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
    
     int LCSRec(int i, int j, string& a, string &b)
    {
        if(i==0 || j==0) return memo[i][j]=0;
        if(memo[i][j] != -1)return memo[i][j];
        if(a[i-1] == b[j-1])
            return memo[i][j] = 1 + LCSRec(i-1, j-1, a, b);
        else
            return memo[i][j] = max(LCSRec(i, j-1, a, b),LCSRec(i-1, j, a, b));
    }
};