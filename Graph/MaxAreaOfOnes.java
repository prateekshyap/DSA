/*https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1*/

class Solution
{
    public int findMaxArea(int[][] grid)
    {
        int max=Integer.MIN_VALUE;
        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[i].length; ++j)
                if(grid[i][j]== 1) max = Math.max(max,dfs(grid,i,j));
        return max;
    }

    public int dfs(int[][] grid, int i, int j)
    {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1)
            return 0;
        grid[i][j] = 0;
        return 1+dfs(grid,i+1,j)+
        		dfs(grid,i,j+1)+
        		dfs(grid,i-1,j)+
        		dfs(grid,i,j-1)+
        		dfs(grid,i-1,j-1)+
        		dfs(grid,i-1,j+1)+
        		dfs(grid,i+1,j-1)+
        		dfs(grid,i+1,j+1);
    }
}