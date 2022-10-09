/*https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k/*/

class Solution {
    Integer[][][] dp;
    final int m = (int)1e9+7;
    public int numberOfPaths(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k];
        dp[0][0][0] = count(grid,k,0,0,0);
        return dp[0][0][0];
    }
    private int count(int[][] grid, int k, int r, int c, int mod)
    {
        mod = (mod+grid[r][c])%k;
        
        if (r == grid.length-1 && c == grid[0].length-1)
            return mod == 0 ? 1 : 0;
        
        if (dp[r][c][mod] != null) return dp[r][c][mod];
        
        long result = 0;
        
        if (r+1 < grid.length)
            result = (result+count(grid,k,r+1,c,mod))%m;
        if (c+1 < grid[0].length)
            result = (result+count(grid,k,r,c+1,mod))%m;
        
        return dp[r][c][mod] = (int)result;
    }
}