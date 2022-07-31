/*
https://leetcode.com/problems/longest-common-subsequence/
1143. Longest Common Subsequence

*/

class Solution {
public:
    vector<vector<int>> memo;
    int longestCommonSubsequence(string text1, string text2) {
        
        int n = text1.size(), m = text2.size();
        memo.resize(n+1, vector<int>(m+1, -1));
        int len=LCSRec(n,m, text1, text2);
        // cout<<printLCS(text1, text2)<<endl;;
        return len;
        // vector<vector<int>> dp(n+1, vector<int>(m+1, 0));
        // for(int i=1; i<=n; i++)
        // {
        //     for(int j=1; j<=m; j++)
        //     {
        //         if(text1[i-1] == text2[j-1])
        //             dp[i][j] = 1 + dp[i-1][j-1];
        //         else
        //             dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
        //     }
        // }
        // return dp[n][m];
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
    
    string printLCS(string a, string b)
    {
        int n = a.size(), m = b.size();
        int i=n, j=m;
        string ans="";
        while(i>0 and j>0)
        {
            if(a[i-1] == b[j-1])
            {
                ans.push_back(a[i-1]);
                --i; --j;
            }
            else
            {
                if(memo[i-1][j] > memo[i][j-1])
                    i--;
                else
                    j--;
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};