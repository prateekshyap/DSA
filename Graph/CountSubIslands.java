/*https://leetcode.com/problems/count-sub-islands/*/

class Solution {
    int m, n;
    int[][] dirs = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    int[][] grid1;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int i, j, count = 0;
        m = grid1.length;
        n = grid1[0].length;
        this.grid1 = grid1;
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                if (grid2[i][j] == 1 && grid1[i][j] == 1)
                    count += dfs(grid2, i, j) ? 1 : 0;
        return count;
    }
    private boolean dfs(int[][] grid, int row, int col)
    {
        grid[row][col] = 2;
        int r, c;
        boolean result = grid1[row][col] == 1;
        
        for (int i = 0; i < 4; ++i)
        {
            r = row+dirs[i][0];
            c = col+dirs[i][1];
            
            if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1)
            {
                if (grid1[r][c] == 1)
                    result &= dfs(grid,r,c);
                else result &= false;
            }
        }
        
        return result;
    }
}