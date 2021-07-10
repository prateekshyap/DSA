/*https://leetcode.com/problems/longest-palindromic-subsequence/*/
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