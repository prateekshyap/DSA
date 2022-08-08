/*https://leetcode.com/problems/range-sum-query-2d-immutable/*/

class NumMatrix {
    int[][] preSum;
    int m, n;
    public NumMatrix(int[][] matrix) {
        m = matrix.length; n = matrix[0].length;
        preSum = new int[m+1][n+1];
        int i, j;
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                preSum[i+1][j+1] = preSum[i][j+1]+preSum[i+1][j]-preSum[i][j]+matrix[i][j];
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2+1][col2+1]-preSum[row1][col2+1]-preSum[row2+1][col1]+preSum[row1][col1];
    }
}