/*https://practice.geeksforgeeks.org/problems/find-whether-path-exist5238/1/*/

class Solution
{
    boolean result;
    int n;
    int destRow, destCol;
    
    public boolean isSafe(int r, int c, int[][] maze, boolean[][] visited) {
        //if boundary conditions violate, return false
        if (r == -1 || r == n || c == -1 || c == n)
            return false;
            
        //if the move is unsafe, return false
        if (visited[r][c] || maze[r][c] == 0)
            return false;
            
        //return true
        return true;
    }
    
    public void checkReachability(int r, int c, int[][] maze, boolean[][] visited) {
        //if conditions violate, return
        if (r == -1 || c == -1 || r == n || c == n || maze[r][c] == 0) return;
        
        //if destination is reached, store true and return
        if (r == destRow && c == destCol)
        {
            result = true;
            return;
        }
        
        visited[r][c] = true; //backtracking step-1
        
        //move in all four directions (backtracking step-2)
        if (isSafe(r+1,c,maze,visited))
            checkReachability(r+1,c,maze,visited);
        if (isSafe(r,c+1,maze,visited))
            checkReachability(r,c+1,maze,visited);
        if (isSafe(r-1,c,maze,visited))
            checkReachability(r-1,c,maze,visited);
        if (isSafe(r,c-1,maze,visited))
            checkReachability(r,c-1,maze,visited);
        
        visited[r][c] = false; //backtracking step - 3
    }
    
    //Function to find whether a path exists from the source to destination.
    public boolean is_Possible(int[][] grid)
    {
        // Code here
        result = false;
        n = grid.length;
        int srcRow = -1, srcCol = -1;
        int i = 0, j = 0;
        
        //find out source and destination
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (grid[i][j] == 1)
                {
                    srcRow = i;
                    srcCol = j;
                }
                else if (grid[i][j] == 2)
                {
                    destRow = i;
                    destCol = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[n][n];
        checkReachability(srcRow, srcCol, grid, visited);
        
        return result;
    }
}