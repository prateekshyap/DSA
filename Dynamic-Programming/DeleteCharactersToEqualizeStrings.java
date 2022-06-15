/*https://binarysearch.com/problems/Delete-Characters-to-Equalize-Strings*/

import java.util.*;

class Solution {
    public int solve(String a, String b) {
        int i, j, m = a.length(), n = b.length();
        int[][] dp = new int[m+1][n+1];
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (a.charAt(i) == b.charAt(j)) dp[i+1][j+1] = dp[i][j]+1;
                else if (dp[i+1][j] > dp[i][j+1]) dp[i+1][j+1] = dp[i+1][j];
                else dp[i+1][j+1] = dp[i][j+1];
            }
        }

        return m+n-2*dp[m][n];
    }
}