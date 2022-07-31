/*https://leetcode.com/problems/longest-increasing-path-in-a-matrix/*/

class Solution {
    int max = 0;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int[][] dp;
    int m, n;
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        m = matrix.length;
        n = matrix[0].length;
        dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < dp.length; i++)
            for (int j = 0; j < dp[0].length; j++)
                dfs(matrix, i, j);
        return max;
    }
    private int dfs(int[][] matrix, int row, int col) {
        if (dp[row][col] != 0) return dp[row][col];
        dp[row][col] = 1;
        int maxDir = 0, i, r, c;
        for (i = 0; i < 4; ++i)
        {
            r = row+pos[i][0];
            c = col+pos[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] < matrix[row][col])
                maxDir = Math.max(dfs(matrix,r,c), maxDir);
        }
        dp[row][col] = maxDir+1;
        max = Math.max(max, dp[row][col]);
        return dp[row][col];
    }
}