/*https://leetcode.com/problems/largest-local-values-in-a-matrix/*/

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        
        int [][] result = new int [n - 2][n - 2];
        int max;
        
        for (int i = 0; i < n - 2; ++i){
            for (int j = 0; j < n - 2; ++j){
                max = 1;
                for (int a = 0; a < 3; ++a){
                    for (int b = 0; b < 3; ++b){
                        max = Math.max(max, grid[i + a][j + b]);
                    }
                }
                
                result[i][j] = max;
            }
        }
        
        return result;
    }
}

class Solution {
    public int[][] largestLocal(int[][] grid) {
        int i, j, k, n = grid.length;
        int[][] ng = new int[n-2][n-2];
        for (i = 1; i < n-1; ++i)
        {
            for (j = 1; j < n-1; ++j)
            {
                ng[i-1][j-1] = getMax(grid[i][j],grid[i-1][j],grid[i+1][j],grid[i][j-1],grid[i-1][j-1],grid[i+1][j-1],grid[i-1][j+1],grid[i+1][j+1],grid[i][j+1]);
            }
        }
        return ng;
    }
    public int getMax(int... a)
    {
        int max = Integer.MIN_VALUE;
        for (int i : a)
            if (i > max)
                max = i;
        return max;
    }
}