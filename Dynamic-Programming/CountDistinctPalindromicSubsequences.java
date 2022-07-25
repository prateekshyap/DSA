/*https://practice.geeksforgeeks.org/problems/count-palindromic-subsequences/1*/

class Solution {
    static final int m = (int)1e9+7;
    Integer[][][] dp;
    public int countPalindromicSubsequences(String str) {
        // Your code here
        int n = str.length();
        dp = new Integer[n][n][4];
        int result = 0;
        for (int ch = 0; ch < 4; ++ch)
        {
            dp[0][n-1][ch] = count(str,0,n-1,ch);
            result += dp[0][n-1][ch];
            result %= m;
        }
        
        return result;
    }
    private int count(String str, int i, int j, int c)
    {
        if (i > j) return 0;
        if (i == j)
        {
            if (str.charAt(i)-'a' == c)
                dp[i][j][c] = 1;
            else dp[i][j][c] = 0;
            return dp[i][j][c];
        }
        if (dp[i][j][c] != null) return dp[i][j][c];
        if (str.charAt(i) == str.charAt(j) && str.charAt(i)-'a' == c)
        {
            dp[i][j][c] = 2;
            for (int ch = 0; ch < 4; ++ch)
                dp[i][j][c] = (dp[i][j][c]+count(str,i+1,j-1,ch))%m;
        }
        else dp[i][j][c] = (count(str,i+1,j,c)+count(str,i,j-1,c)-count(str,i+1,j-1,c))%m;
        if (dp[i][j][c] < 0) dp[i][j][c] += m;
        return dp[i][j][c];
    }
}