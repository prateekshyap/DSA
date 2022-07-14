/*https://practice.geeksforgeeks.org/problems/maximum-sum-rectangle2948/1*/

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int[][] preSum = new int[R+1][C];
        int i, j, rs, re, col, maxSum = Integer.MIN_VALUE, sum;
        for (i = 1; i <= R; ++i)
            for (j = 0; j < C; ++j)
                preSum[i][j] = preSum[i-1][j]+M[i-1][j];
        for (rs = 0; rs < R; ++rs)
        {
            for (re = rs+1; re <= R; ++re)
            {
                sum = 0;
                for (col = 0; col < C; ++col)
                {
                    sum += preSum[re][col]-preSum[rs][col];
                    if (sum > maxSum) maxSum = sum;
                    else if (sum < 0) sum = 0;
                }
            }
        }
        return maxSum;
    }
}

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        int[][] preSum = new int[R][C+1];
        int i, j, rs, re, col, maxSum = Integer.MIN_VALUE, sum;
        for (i = 1; i <= C; ++i)
            for (j = 0; j < R; ++j)
                preSum[j][i] = preSum[j][i-1]+M[j][i-1];
        for (rs = 0; rs < C; ++rs)
        {
            for (re = rs+1; re <= C; ++re)
            {
                sum = 0;
                for (col = 0; col < R; ++col)
                {
                    sum += preSum[col][re]-preSum[col][rs];
                    if (sum > maxSum) maxSum = sum;
                    else if (sum < 0) sum = 0;
                }
            }
        }
        return maxSum;
    }
}