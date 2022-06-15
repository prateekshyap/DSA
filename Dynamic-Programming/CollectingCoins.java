/*https://binarysearch.com/problems/Collecting-Coins*/

import java.util.*;

class Solution {
    //Integer[][] dp;
    public int solve(int[][] m) {
        //dp = new Integer[m.length][m[0].length];
        //return recur(m, 0, 0);
        int r = m.length, c = m[0].length;
        int i, j;
        for (i = 0; i < r-1; ++i)
            m[i+1][0] += m[i][0];
        for (i = 0; i < c-1; ++i)
            m[0][i+1] += m[0][i];
        for (i = 1; i < r; ++i)
            for (j = 1; j < c; ++j)
                m[i][j] += Math.max(m[i-1][j],m[i][j-1]);
        return m[r-1][c-1];
    }
    /*public int recur(int[][] m, int r, int c)
    {
        if (r == m.length-1 && c == m[0].length-1)
        {
            dp[r][c] = new Integer(m[r][c]);
            return m[r][c];
        }
        int result1 = 0, result2 = 0;
        if (r == m.length-1)
        {
            if (dp[r][c+1] == null) dp[r][c+1] = recur(m,r,c+1);
            return m[r][c]+dp[r][c+1];
        }
        else if (c == m[0].length-1)
        {
            if (dp[r+1][c] == null) dp[r+1][c] = recur(m,r+1,c);
            return m[r][c]+dp[r+1][c];
        }
        if (dp[r][c+1] == null) dp[r][c+1] = recur(m,r,c+1);
        if (dp[r+1][c] == null) dp[r+1][c] = recur(m,r+1,c);
        return m[r][c]+Math.max(dp[r][c+1] == null ? 0 : dp[r][c+1],dp[r+1][c] == null ? 0 : dp[r+1][c]);
    }*/
}