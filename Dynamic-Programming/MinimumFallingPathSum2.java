/*https://leetcode.com/problems/minimum-falling-path-sum-ii/*/

//simple DP solution (O(n^))
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];
        int n = matrix.length;
        int[][] result = new int[n][matrix[0].length];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < matrix[i].length; ++j)
                result[i][j] = i == 0 ? matrix[i][j] : Integer.MAX_VALUE;
        
        for (int i = 0; i < n-2; ++i)
            for (int j = 0; j < matrix[i].length; ++j)
                for (int k = 0; k < matrix[i].length; ++k)
                    if (j != k)
                        result[i+1][k] = Math.min(result[i+1][k],result[i][j]+matrix[i+1][k]);

        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < matrix[n-1].length; ++j)
            for (int k = 0; k < matrix[n-1].length; ++k)
                if (j != k)
                {
                    result[n-1][k] = Math.min(result[n-1][k],result[n-2][j]+matrix[n-1][k]);
                    min = Math.min(min,result[n-1][k]);
                }
        
        return min;
    }
}

//efficient solution (O(n^2))

class Solution {
    public int minFallingPathSum(int[][] grid) {
        int M = grid.length, N = grid[0].length;
        int row, col;
        int min = 0, secondMin = 0, minIndex = -1, nextMin, nextSecondMin, nextMinIndex, currResult = 0;
        
        for (row = 0; row < M; ++row)
        {
            nextMin = Integer.MAX_VALUE; nextSecondMin = Integer.MAX_VALUE; nextMinIndex = -1;
            for (col = 0; col < N; ++col)
            {
                if (col == minIndex) currResult = grid[row][col]+secondMin;
                else currResult = grid[row][col]+min;
                if (currResult < nextMin)
                {
                    nextSecondMin = nextMin;
                    nextMin = currResult;
                    nextMinIndex = col;
                }
                else if (currResult < nextSecondMin)
                    nextSecondMin = currResult;
            }
            min = nextMin; secondMin = nextSecondMin; minIndex = nextMinIndex;
        }
        return min;
    }
}