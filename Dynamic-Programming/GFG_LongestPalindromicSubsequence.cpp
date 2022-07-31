/*
https://leetcode.com/problems/longest-palindromic-subsequence/
Longest Palindromic Subsequence
https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1
*/

class Solution{
  public:
  
  int longestPalinSubseq(string A) {
        int n = A.length();
        vector<int> dp(n, 0);
    
        for(int i=0; i<n; i++)
        {
            dp[i] = 1;
            int maxsofar=0;
            for(int j=i-1; j>=0; --j)
            {
                int prev = dp[j];
                if(A[i]==A[j])
                    dp[j] = maxsofar + 2;
                maxsofar = max(maxsofar, prev);
               
            }
        }
       return *max_element(dp.begin(), dp.end());
   }
   
   int longestPalinSubseq_1(string A) {
        int n = A.length();
        vector<vector<int>> dp(n, vector<int>(n, 0));
        
        for(int i=0; i<n; i++)
            dp[i][i] = 1;
        
        for(int k=2; k<=n; k++)
        {
            for(int i=0; i<n-k+1; ++i)
            {
                int j = i+k-1;
                if(A[i]==A[j])
                    dp[i][j] = dp[i+1][j-1] + 2;
                else
                    dp[i][j] = max(dp[i+1][j], dp[i][j-1]);
            }
        }
        
    // cout<<"  ";
    // for(int i=0; i<n; i++)
    // {
    //     cout<<A[i]<<" ";
    // }
    // cout<<endl;
    // for(int i=0; i<n; i++)
    // {
    //     cout<<A[i]<<" ";
    //     for(int j=0; j<n; j++)
    //     {
    //         cout<<dp[i][j]<<" ";
    //     }
    //     cout<<endl;
    // }

       return dp[0][n-1];
   }
    int longestPalinSubseq_(string A) {
        string B = A;
        reverse(B.begin(), B.end());
        int n = A.length();
        vector<vector<int>> dp(n+1, vector<int>(n+1, 0));
        
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(A[i-1] == B[j-1])
                    dp[i][j] = 1+dp[i-1][j-1];
                else
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                // cout<<dp[i][j]<<" ";
            }
            // cout<<endl;
        }
        return dp[n][n];
    }
};