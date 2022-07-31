/*https://practice.geeksforgeeks.org/problems/wildcard-string-matching1126/1*/

class Solution{
    static boolean[][] dp;
    static boolean match(String wild, String pattern)
    {
        // code here
        int m = wild.length(), n = pattern.length();
        dp = new boolean[m][n];
        return recur(m-1,n-1,wild,pattern);
    }
    static boolean recur(int i, int j, String s, String p)
    {
        int k;
        if (i < 0 && j < 0) return true;
        if (i < 0) return false;
        if (i >= 0 && j < 0)
        {
            for (k = 0; k <= i; ++k) if (s.charAt(k) != '*') return false;
            return true;
        }
        if (dp[i][j]) return dp[i][j];
        if (s.charAt(i) == p.charAt(j) || s.charAt(i) == '?')
        {
            dp[i][j] = recur(i-1,j-1,s,p);
            return dp[i][j];
        }
        if (s.charAt(i) == '*')
        {
            dp[i][j] = recur(i-1,j,s,p)||recur(i,j-1,s,p);
            return dp[i][j];
        }
        dp[i][j] = false;
        return dp[i][j];
    }
}