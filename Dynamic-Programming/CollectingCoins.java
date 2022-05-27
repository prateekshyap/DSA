/*https://binarysearch.com/problems/Collecting-Coins*/

import java.util.*;

class Solution {
    //Integer[][] dp;
    public int solve(int[][] matrix) {
        //dp = new Integer[matrix.length][matrix[0].length];
        //return recur(matrix, 0, 0);
        int i, j;
        for (i = 0; i < matrix.length-1; ++i)
            matrix[i+1][0] += matrix[i][0];
        for (i = 0; i < matrix[0].length-1; ++i)
            matrix[0][i+1] += matrix[0][i];
        for (i = 1; i < matrix.length; ++i)
            for (j = 1; j < matrix[0].length; ++j)
                matrix[i][j] += Math.max(matrix[i-1][j],matrix[i][j-1]);
        return matrix[matrix.length-1][matrix[0].length-1];
    }
    /*public int recur(int[][] matrix, int r, int c)
    {
        if (r == matrix.length-1 && c == matrix[0].length-1)
        {
            dp[r][c] = new Integer(matrix[r][c]);
            return matrix[r][c];
        }
        int result1 = 0, result2 = 0;
        if (r == matrix.length-1)
        {
            if (dp[r][c+1] == null) dp[r][c+1] = recur(matrix,r,c+1);
            return matrix[r][c]+dp[r][c+1];
        }
        else if (c == matrix[0].length-1)
        {
            if (dp[r+1][c] == null) dp[r+1][c] = recur(matrix,r+1,c);
            return matrix[r][c]+dp[r+1][c];
        }
        if (dp[r][c+1] == null) dp[r][c+1] = recur(matrix,r,c+1);
        if (dp[r+1][c] == null) dp[r+1][c] = recur(matrix,r+1,c);
        return matrix[r][c]+Math.max(dp[r][c+1] == null ? 0 : dp[r][c+1],dp[r+1][c] == null ? 0 : dp[r+1][c]);
    }*/
}