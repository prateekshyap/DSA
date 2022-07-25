/*https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1*/
class Solution
{
    long countPS(String S)
    {
        int n = S.length();
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; ++i)
        {
            dp[i][i] = 1;
        }
        for (int k = 2; k <= n; ++k)
        {
            for (int i = 0; i < n-k+1; ++i)
            {
                int j = i+k-1;
                if (S.charAt(i) == S.charAt(j))
                    dp[i][j] = (dp[i][j-1]+dp[i+1][j]+1)%1000000007;
                else
                    dp[i][j] = (dp[i][j-1]+dp[i+1][j]-dp[i+1][j-1])%1000000007;
                if (dp[i][j] < 0) dp[i][j] += 1000000007;
            }
        }
        return dp[0][n-1];
    }
}

class Solution
{
    static final long m = (long)1e9+7;
    Long[][] dp;
    long countPS(String str)
    {
        // Your code here
        dp = new Long[str.length()][str.length()];
        dp[0][str.length()-1] = count(str,0,str.length()-1);
        return dp[0][str.length()-1];
    }
    private long count(String str, int i, int j)
    {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != null) return dp[i][j];
        if (str.charAt(i) == str.charAt(j))
            dp[i][j] = (count(str,i+1,j)+count(str,i,j-1)+1)%m;
        else dp[i][j] = (count(str,i+1,j)+count(str,i,j-1)-count(str,i+1,j-1))%m;
        if (dp[i][j] < 0) dp[i][j] += m;
        return dp[i][j];
    }
}