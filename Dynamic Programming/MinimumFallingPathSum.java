/*https://leetcode.com/problems/minimum-falling-path-sum/*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];
        int n = matrix.length;
        int[][] result = new int[n][matrix[0].length];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < matrix[i].length; ++j)
                result[i][j] = i == 0 ? matrix[i][j] : Integer.MAX_VALUE;
        
        for (int i = 0; i < n-2; ++i)
        {
            for (int j = 0; j < matrix[i].length; ++j)
            {
                if (j-1 >= 0) result[i+1][j-1] = Math.min(result[i+1][j-1],result[i][j]+matrix[i+1][j-1]);
                result[i+1][j] = Math.min(result[i+1][j],result[i][j]+matrix[i+1][j]);
                if (j+1 < matrix[i].length) result[i+1][j+1] = Math.min(result[i+1][j+1],result[i][j]+matrix[i+1][j+1]);
            }
        }
        
        int min = Integer.MAX_VALUE;
        
        for (int j = 0; j < matrix[n-1].length; ++j)
        {
            if (j-1 >= 0) result[n-1][j-1] = Math.min(result[n-1][j-1],result[n-2][j]+matrix[n-1][j-1]);
            result[n-1][j] = Math.min(result[n-1][j],result[n-2][j]+matrix[n-1][j]);
            if (j+1 < matrix[n-2].length) result[n-1][j+1] = Math.min(result[n-1][j+1],result[n-2][j]+matrix[n-1][j+1]);
            if (j-1 >= 0) min = Math.min(min,result[n-1][j-1]);
            min = Math.min(min,result[n-1][j]);
            if (j+1 < matrix[n-2].length) min = Math.min(min,result[n-1][j+1]);
        }
        
        return min;
    }
}