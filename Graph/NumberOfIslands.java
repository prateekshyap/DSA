/*https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1*/
/*https://binarysearch.com/problems/Number-of-Islands*/

//using DFS
class Solution {
    char[][] grid;
    int r, c;
    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;

        //check for each cell
        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                if (this.grid[i][j] == '1') //if we are still left with unvisited cells
                {
                    runDFS(i, j); //run DFS on it
                    ++count; //increment the count
                }
        return count;
    }
    public void runDFS(int row, int col)
    {
    	//if we consider the diagonals
        int rows[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int cols[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
    
    	//if we don't consider diagonals then remove the comment here
        /*int rows[] = new int[] {-1, 0, 0, 1};
        int cols[] = new int[] {0, -1, 1, 0};*/
        
        // Mark this cell as visited
        grid[row][col] = '0';
 
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) //replace 8 with 4 for the other case
            if ((row + rows[k] >= 0) && (row + rows[k] < r) && (col + cols[k] >= 0) && (col + cols[k] < c) && (grid[row + rows[k]][col + cols[k]] == '1'))
                runDFS(row + rows[k], col + cols[k]);
    }
}

/*DFS*/
import java.util.*;

class Solution {
    int m, n;
    int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    boolean[][] visited;
    public int solve(int[][] matrix) {
        m  = matrix.length; n = matrix[0].length;
        visited = new boolean[m][n];
        int i, j, count = 0;
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (matrix[i][j] == 1 && !visited[i][j])
                {
                    ++count;
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] mt, int row, int col)
    {
        visited[row][col] = true;
        int i, r, c;
        for (i = 0; i < 4; ++i)
        {
            r = row+d[i][0];
            c = col+d[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && mt[r][c] == 1 && !visited[r][c])
                dfs(mt, r, c);
        }
    }
}

/*Without visited matrix*/

import java.util.*;

class Solution {
    int m, n;
    int[][] d = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public int solve(int[][] matrix) {
        m  = matrix.length; n = matrix[0].length;
        int i, j, count = 0;
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (matrix[i][j] == 1)
                {
                    ++count;
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(int[][] mt, int row, int col)
    {
        mt[row][col] = 0;
        int i, r, c;
        for (i = 0; i < 4; ++i)
        {
            r = row+d[i][0];
            c = col+d[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && mt[r][c] == 1)
                dfs(mt, r, c);
        }
    }
}