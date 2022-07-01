/*https://leetcode.com/problems/number-of-enclaves/*/
/*https://binarysearch.com/problems/Enclosed-Islands*/

//simple dfs solution
class Solution {
    boolean[][] visited;
    int coveredOnes, m, n;
    int[][] d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        int i, j, totalOnes = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        coveredOnes = 0;

        //count the number of total 1s
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                if (grid[i][j] == 1) ++totalOnes;
        
        //count the number of 1s those can be covered from each boundary
        for (i = 0; i < m; ++i) //left boundary
        {
            if (grid[i][0] == 1 && !visited[i][0]) //if current cell is 1 and unvisited
                dfs(grid, i, 0);
        }
        
        for (j = 0; j < n; ++j) //top boundary
        {
            if (grid[0][j] == 1 && !visited[0][j]) //if current cell is 1 and unvisited
                dfs(grid, 0, j);
        }
        
        for (i = 0; i < m; ++i) //right boundary
        {
            if (grid[i][n-1] == 1 && !visited[i][n-1]) //if current cell is 1 and unvisited
                dfs(grid, i, n-1);
        }
        
        for (j = 0; j < n; ++j) //bottom boundary
        {
            if (grid[m-1][j] == 1 && !visited[m-1][j]) //if current cell is 1 and unvisited
                dfs(grid, m-1, j);
        }
        
        return totalOnes-coveredOnes;
    }
    
    public void dfs(int[][] grid, int r, int c)
    {
        visited[r][c] = true; //mark as visited
        ++coveredOnes; //count covered ones
        for (int i = 0; i < 4; ++i) //for each direction
            if (isFeasible(grid,r+d[i][0],c+d[i][1])) //if feasible
                dfs(grid, r+d[i][0], c+d[i][1]); //recur
    }
    
    public boolean isFeasible(int[][] grid, int r, int c)
    {
        if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c]) return true;
        return false;
    }
}

//above solution optimized version
class Solution {
    boolean[][] visited;
    int coveredOnes, m, n;
    int[][] d = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    public int numEnclaves(int[][] grid) {
        int i, j, totalOnes = 0;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        coveredOnes = 0;
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                totalOnes += grid[i][j];
        
        for (i = 0; i < m; ++i)
        {
            dfs(grid, i, 0); //left boundary
            dfs(grid, i, n-1); //right boundary
        }
        
        for (j = 0; j < n; ++j)
        {
            dfs(grid, 0, j); //top boundary
            dfs(grid, m-1, j); //bottom boundary
        }
        
        return totalOnes-coveredOnes;
    }
    
    public void dfs(int[][] grid, int r, int c)
    {
        if (!isFeasible(grid, r, c)) return;
        visited[r][c] = true;
        ++coveredOnes;
        for (int i = 0; i < 4; ++i)
            dfs(grid, r+d[i][0], c+d[i][1]);
    }
    
    public boolean isFeasible(int[][] grid, int r, int c)
    {
        if(r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1 && !visited[r][c]) return true;
        return false;
    }
}

//another efficient solution in reverse direction
class Solution {
    public int numEnclaves(int[][] grid) {
        //flood for each boundary and modify all reachable 1s to 0s

        for (int y = 0; y < grid.length; y++) {
            flood(grid, y, 0); //left boundary
            flood(grid, y, grid[y].length - 1); //right boundary
        }
        
        for (int x = 0; x < grid[0].length; x++) {
            flood(grid, 0, x); //top boundary
            flood(grid, grid.length - 1, x); //bottom boundary
        }
        
        //count the number of 1s and return
        int res = 0;
        for (int y = 1; y < grid.length - 1; y++) {
            for (int x = 1; x < grid[y].length - 1; x++) {
                res += grid[y][x];
            }
        }
        return res;
    }
    
    private static void flood(int[][] grid, int y, int x) {

        //if infeasible, return
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[y].length || grid[y][x] != 1) {
            return;
        }
        
        grid[y][x] = 0; //set 0

        //flood for each direction
        flood(grid, y - 1, x);
        flood(grid, y + 1, x);
        flood(grid, y, x - 1);
        flood(grid, y, x + 1);
    }
}

import java.util.*;

class Solution {
    int  m, n;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int solve(int[][] matrix) {
        int i, j;
        m = matrix.length; n = matrix[0].length;

        for (i = 0; i < m; ++i)
        {
            if (matrix[i][0] == 1) dfs(matrix,i,0);
            if (matrix[i][n-1] == 1) dfs(matrix,i,n-1);
        }

        for (j = 0; j < n; ++j)
        {
            if (matrix[0][j] == 1) dfs(matrix,0,j);
            if (matrix[m-1][j] == 1) dfs(matrix,m-1,j);
        }

        int result = 0;
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                result += matrix[i][j];

        return result;
    }
    public void dfs(int[][] matrix, int row, int col)
    {
        matrix[row][col] = 0;
        int r, c, i;
        for (i = 0; i < 4; ++i)
        {
            r = row+pos[i][0];
            c = col+pos[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && matrix[r][c] == 1)
                dfs(matrix,r,c);
        }
    }
}