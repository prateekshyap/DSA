/*https://leetcode.com/problems/minimum-falling-path-sum-ii/*/

//simple DP solution (O(n^2))
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

//efficient solution (O(n^3))

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) return matrix[0][0];
        int n = matrix.length;        
        int min1 = 0, min2 = 0;
        int min1Index = -1;
        
        for (int i = 0; i < n; ++i)
        {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE;
            int newMin1Index = -1;
            for (int j = 0; j < matrix[i].length; ++j)
            {
                int res = 0;
                if (j == min1Index)
                    res = matrix[i][j]+min2;
                else
                    res = matrix[i][j]+min1;
                if (res < newMin1)
                {
                    newMin2 = newMin1;
                    newMin1 = res;
                    newMin1Index = j;
                }
                else if (res < newMin2)
                    newMin2 = res;
            }
            min1 = newMin1;
            min2 = newMin2;
            min1Index = newMin1Index;
        }

        return min1;
    }
}