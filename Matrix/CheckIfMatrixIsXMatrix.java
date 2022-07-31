/*https://leetcode.com/problems/check-if-matrix-is-x-matrix/*/

class Solution {
    public boolean checkXMatrix(int[][] grid)
    {
        int n = grid.length, i = 0, j = 0, k = n-1;
        boolean result = true;
        while (i < n)
        {
            if (grid[i][j] == 0 || grid[i][k] == 0) return false;
            grid[i][j] = grid[i][k] = -1;
            ++j; --k;
            ++i;
        }
        for (i = 0; i < n; ++i)
            for (j = 0; j < n; ++j)
                if (grid[i][j] > 0)
                    return false;
        return true;
    }
}