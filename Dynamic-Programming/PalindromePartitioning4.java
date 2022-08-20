/*https://leetcode.com/problems/palindrome-partitioning-iv/*/

class Solution {
    public boolean checkPartitioning(String s) {
        if (s.length() == 0) return false;
        char[] a = s.toCharArray();
        int n = s.length(), i, j, len = 0;
        boolean[][] dp = new boolean[n+1][n+1];
        for (i = 0; i < n; ++i)
            dp[i][i] = true;
        for (i = 0; i < n-1; ++i)
            if (a[i] == a[i+1])
                dp[i][i+1] = true;
        for (len = 3; len <= n; ++len)
        {
            for (i = 0; i < n-len+1; ++i)
            {
                j = i+len-1;
                if (dp[i+1][j-1] && a[i] == a[j])
                    dp[i][j] = true;
            }
        }
        for (i = 0; i < n-2; ++i)
        {
            if (dp[0][i])
            {
                for (j = i+1; j < n-1; ++j)
                {
                    if (dp[i+1][j] && dp[j+1][n-1])
                        return true;
                }
            }
        }
        return false;
    }
}