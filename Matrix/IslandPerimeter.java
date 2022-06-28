/*https://leetcode.com/problems/island-perimeter/*/

class Solution {
    public int islandPerimeter(int[][] grid)
    {
        int count = 0;
        
        for (int i = 0; i < grid.length; i++)
        {
            for (int j = 0; j < grid[0].length; j++)
            {
                if (grid[i][j] == 1)
                {
                    int res = 0;
                    res += check(i-1,j,grid.length, grid[0].length, grid);
                    res += check(i+1,j,grid.length, grid[0].length, grid);
                    res += check(i,j+1,grid.length, grid[0].length, grid);
                    res += check(i,j-1,grid.length, grid[0].length, grid);
                    
                    count += res;
                }
            }
        }
        
        return count;
    }
    
    public int check(int i, int j, int n, int m, int [][] grid)
    {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 1;
        else if (grid[i][j] == 0)
            return 1;
        return 0;
    }
}

class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    //Top
                    if(i==0 || grid[i-1][j] == 0) {
                        count++;
                    }
                    //Left
                    if(j == 0 || grid[i][j-1] == 0) {
                        count++;
                    }
                    //Down
                    if(i == n-1 || grid[i+1][j] == 0) {
                        count++;
                    }
                    //Right
                    if(j == m-1 || grid[i][j+1] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}