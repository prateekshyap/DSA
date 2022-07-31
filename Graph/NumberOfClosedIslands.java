/*https://leetcode.com/problems/number-of-closed-islands/*/
/*https://practice.geeksforgeeks.org/problems/find-number-of-closed-islands/1/*/

//LC
class Solution {
    boolean[][] visited;
    int m, n;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int i, j, islands = 0;
        visited = new boolean[m][n];
        for (i = 1; i < m-1; ++i) //for all rows apart from first and last
            for (j = 1; j < n-1; ++j) //for all columns apart from first and last
                if (grid[i][j] == 0 && !visited[i][j] && dfs(grid,i,j)) //if the cell is 0, not visited and dfs returns true
                    ++islands; //increase the number of islands
        return islands; //return
    }
    public boolean dfs(int[][] grid, int row, int col)
    {
        visited[row][col] = true; //mark current cell as visited
        if ((row == 0 || row == m-1 || col == 0 || col == n-1) && grid[row][col] == 0) return false; //if on border and cell is a land, the region cannot be island
        int r, c, i;
        boolean result = true; //mark result as true
        for (i = 0; i < 4; ++i) //for each cell adjacent to it
        {
            r = row+pos[i][0];
            c = col+pos[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] == 0) //if a land and not yet visited
                result &= dfs(grid,r,c); //and the dfs result to result
        }
        return result;
    }
}

//GFG
class Solution
{
    boolean[][] visited;
    int m, n;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int closedIslands(int[][] matrix, int N, int M)
    {
        // Code here
        m = matrix.length;
        n = matrix[0].length;
        int i, j, islands = 0;
        visited = new boolean[m][n];
        for (i = 1; i < m-1; ++i) //for all rows apart from first and last
            for (j = 1; j < n-1; ++j) //for all columns apart from first and last
                if (matrix[i][j] == 1 && !visited[i][j] && dfs(matrix,i,j)) //if the cell is 0, not visited and dfs returns true
                    ++islands; //increase the number of islands
        return islands; //return
    }
    public boolean dfs(int[][] grid, int row, int col)
    {
        visited[row][col] = true; //mark current cell as visited
        if ((row == 0 || row == m-1 || col == 0 || col == n-1) && grid[row][col] == 1) return false; //if on border and cell is a land, the region cannot be island
        int r, c, i;
        boolean result = true; //mark result as true
        for (i = 0; i < 4; ++i) //for each cell adjacent to it
        {
            r = row+pos[i][0];
            c = col+pos[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] == 1) //if a land and not yet visited
                result &= dfs(grid,r,c); //and the dfs result to result
        }
        return result;
    }
}