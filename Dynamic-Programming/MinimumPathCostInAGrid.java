/*https://leetcode.com/problems/minimum-path-cost-in-a-grid/*/

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int i, j, k, m = grid.length, n = grid[0].length, ans = Integer.MAX_VALUE;
        int[][] result = new int[m][n];
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                result[i][j] = Integer.MAX_VALUE;
        for (j = 0; j < n; ++j) result[0][j] = grid[0][j];
        for (i = 0; i < m-1; ++i)
            for (j = 0; j < n; ++j)
                for (k = 0; k < n; ++k)
                    if (result[i][k]+moveCost[grid[i][k]][j]+grid[i+1][j] < result[i+1][j])
                        result[i+1][j] = result[i][k]+moveCost[grid[i][k]][j]+grid[i+1][j];
        for (j = 0; j < n; ++j) if (result[m-1][j] < ans) ans = result[m-1][j];
        return ans;
    }
}