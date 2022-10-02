/*https://leetcode.com/problems/maximum-sum-of-an-hourglass/*/

//sliding hourglass
class Solution {
    public int maxSum(int[][] grid) {
        int R = grid.length, C= grid[0].length, max = 0;
        for (int i = 0; i < R-2; ++i)
        {
            int sum = grid[i][0]+grid[i][1]+grid[i][2]+grid[i+1][1]+grid[i+2][0]+grid[i+2][1]+grid[i+2][2];
            max = Math.max(sum,max);
            for (int j = 2; j < C-1; ++j)
            {
                sum -= grid[i][j-2]+grid[i+1][j-1]+grid[i+2][j-2];
                sum += grid[i][j+1]+grid[i+1][j]+grid[i+2][j+1];
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}