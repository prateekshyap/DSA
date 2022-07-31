/*https://leetcode.com/problems/cherry-pickup-ii/*/

class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length, n = grid[0].length, i, j, k, p, q;
        Integer[][][] dp = new Integer[m][n][n];
        dp[0][0][n-1] = grid[0][0]+grid[0][n-1];
        for (i = 1; i < m; ++i) // for each row
        {
            for (j = 0; j < n; ++j) // for robot1
            {
                for (k = 0; k < n; ++k) //for robot2
                {
                    if (dp[i-1][j][k] != null)
                    {
                        for (p = Math.max(0,j-1); p <= Math.min(j+1,n-1); ++p)
                        {
                            for (q = Math.max(0,k-1); q <= Math.min(k+1,n-1); ++q)
                            {
                                if (p == q) continue;
                                dp[i][p][q] = dp[i][p][q] == null ? dp[i-1][j][k]+grid[i][p]+grid[i][q] : Math.max(dp[i][p][q],dp[i-1][j][k]+grid[i][p]+grid[i][q]);
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for (j = 0; j < n; ++j)
            for (k = 0; k < n; ++k)
                if (dp[m-1][j][k] != null && dp[m-1][j][k] > max) max = dp[m-1][j][k];
        return max;
    }
}

class Solution {
    int[][][] dp = null;
    public int cherryPickup(int[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		dp = new int[grid.length][grid[0].length][grid[0].length];
		return dfs(grid,0,0,m-1);
    }
    int dfs(int[][]grid,int r,int c1,int c2) {
        if(r<0 || c1<0 ||c2<0 || r>grid.length-1 || c1>grid[0].length-1 || c2>grid[0].length-1 )
            return 0;
        int curr = (c1 == c2 ? grid[r][c1] : grid[r][c1] + grid[r][c2]);
        if(r == grid.length-1){
            return curr;
        }
          if(dp[r][c1][c2] > 0)
            return dp[r][c1][c2];
        if(dp[r][c2][c1] > 0) // it doesn't matter which robot is at c1 and which is on c2
            return dp[r][c2][c1];
        int res = 0;
		//each robot can move in 3 downward direction so total combination for 2 robots are 3*3 = 9
        res = dfs(grid, r+1, c1-1, c2-1);
        res = Math.max(res, dfs(grid, r+1, c1-1, c2));
        res = Math.max(res, dfs(grid, r+1, c1-1, c2+1));
        res = Math.max(res, dfs(grid, r+1, c1, c2-1));
        res = Math.max(res, dfs(grid, r+1, c1, c2));
        res = Math.max(res, dfs(grid, r+1, c1, c2+1));
        res = Math.max(res, dfs(grid, r+1, c1+1, c2-1));
        res = Math.max(res, dfs(grid, r+1, c1+1, c2));
        res = Math.max(res, dfs(grid, r+1, c1+1, c2+1));
           dp[r][c1][c2] = res + curr;
        dp[r][c2][c1] = dp[r][c1][c2];
        return dp[r][c1][c2];
    }
    
}