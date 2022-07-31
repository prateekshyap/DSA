/*
https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1
Count Palindromic Subsequences
*/

class Solution{
    public:
    const int mod = 1e9+7;
    vector<vector<long long int>> memo;
    string s;
    /*You are required to complete below method */
    long long int  countPS(string str)
    {
        int n = str.length();
        // s = str;
        // memo.resize(n+1, vector<long long int>(n+1, -1));
        // return solve( 0, n-1);
        
        vector<vector<long long int>> dp(n, vector<long long int>(n, 0));
        
        for(int i=0; i<n; i++)
            dp[i][i] = 1;
        
        for(int k=2; k<=n; k++)
        {
            for(int i=0; i<n-k+1; ++i)
            {
                int j = i+k-1;
                if(str[i]==str[j])
                    dp[i][j] = (dp[i+1][j]+dp[i][j-1] + 1)%mod;
                else
                    dp[i][j] = (dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1])%mod;
                if(dp[i][j]<0) dp[i][j] += mod;
            }
        }
       return dp[0][n-1];
        
    }
    
    long long int solve(int i, int j)
    {
        if(i>j)  return 0;
        if(i==j) // palindrome of length 1
            return 1;
        if(memo[i][j] != -1) return memo[i][j];
        
        if(s[i]==s[j]) // if first and last char are same
             memo[i][j] = (1+solve( i+1, j) + solve( i, j-1))%mod;
        else
             memo[i][j] = (solve( i+1, j) + solve( i, j-1) - solve(i+1, j-1))%mod;
        if(memo[i][j]<0) memo[i][j] += mod;
        return memo[i][j];
    }
     
};