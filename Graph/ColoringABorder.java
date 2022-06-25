/*https://leetcode.com/problems/coloring-a-border/*/

class Solution {
    boolean[][] visited;
    int m, n;
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        dfs(grid, row, col, color, grid[row][col]);
        return grid;
    }
    public void dfs (int[][] grid, int row, int col, int newColor, int oldColor)
    {
        visited[row][col] = true;
        int count = 0;
        int i;
        for (i = 0; i < 4; ++i)
        {
            int r = directions[i][0]+row;
            int c = directions[i][1]+col;
            
            if (r < 0 || c < 0 || r >= m || c >= n ) continue;
        
            if (visited[r][c]) ++count;
            else if (grid[r][c] == oldColor)
            {
                ++count;
                dfs(grid, r, c, newColor, oldColor);
            }
        }
        
        if (count != 4)
            grid[row][col] = newColor;
    }
}