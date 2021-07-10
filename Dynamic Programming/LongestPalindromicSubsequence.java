/*https://practice.geeksforgeeks.org/problems/longest-palindromic-subsequence-1612327878/1*/

/*
If the current characters are equal
Then check for the remaining string between them
Otherwise check for both the cases-
by removing the first character
by removing the last character
*/

class Solution
{
    public int longestPalinSubseq(String S)
    {
        int n = S.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i)
            dp[i][i] = 1;
        for (int k = 2; k <= n; ++k)
        {
            for (int i = 0; i < n-k+1; ++i)
            {
                int j = i+k-1;
                if (S.charAt(i) == S.charAt(j) && k == 2)
                    dp[i][j] = 2;
                else if (S.charAt(i) == S.charAt(j))
                    dp[i][j] = dp[i+1][j-1]+2;
                else
                    dp[i][j] = Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][n-1];
    }
}

/*Pratik's Approach*/
class Solution {
    public int longestPalindromeSubseq(String s) 
    {
        int len = s.length();
        String srev = new StringBuffer(s).reverse().toString();
        int dp[][] = new int[len+1][len+1];
        for(int i=1;i<=len;i++)
        {
            for(int j=1;j<=len;j++)
            {
                if(s.charAt(i-1)!=srev.charAt(j-1))
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
                else
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
            }
        }
        return dp[len][len];
    }
}
/*Best one*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] sa = s.toCharArray();
        int[] dp = new int[sa.length];
        int max = 0;
        for (int i = 0; i < dp.length; i++ ) {
            dp[i] = 1; 
            int maxSoFar = 0;
            for (int j = i - 1; j >= 0; j--) {
                int prev = dp[j]; 
                if (sa[i] == sa[j]) {
                    dp[j] = maxSoFar + 2;
                }
                maxSoFar = Math.max(prev, maxSoFar);
            }
        }
        for (int i : dp) max = Math.max(max, i);
        return max;
    }
}