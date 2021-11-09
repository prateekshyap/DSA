/*https://leetcode.com/problems/minimum-path-sum/*/

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i)
            for (int j = 0; j < grid[0].length; ++j)
                result[i][j] = Integer.MAX_VALUE;
        result[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; ++i)
        {
            for (int j = 0; j < grid[0].length; ++j)
            {
                if (i+1 < grid.length) result[i+1][j] = Math.min(result[i+1][j],result[i][j]+grid[i+1][j]);
                if (j+1 < grid[0].length) result[i][j+1] = Math.min(result[i][j+1],result[i][j]+grid[i][j+1]);
            }
        }
        
        return result[grid.length-1][grid[0].length-1];
    }
}