/*https://leetcode.com/problems/matrix-block-sum/*/

/*simple solution*/
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        int i, j, p, q;
        int elem;
        
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                elem = mat[i][j];
                for (p = Math.max(0,i-k); p <= Math.min(m-1,i+k); ++p)
                    for (q = Math.max(0,j-k); q <= Math.min(n-1,j+k); ++q)
                        result[p][q] += elem;
            }
        }
        
        return result;
    }
}

/*prefix sum solution*/
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        int i, j, p, q, r, c;
        int elem;
        
        for (i = 0; i < m; ++i) result[i][0] = mat[i][0];
        
        for (i = 0; i < m; ++i) for (j = 1; j < n; ++j) result[i][j] = result[i][j-1]+mat[i][j];
        
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
            {
                mat[i][j] = 0;
                r = Math.min(m-1,i+k);
                c = Math.min(n-1,j+k);
                for (p = Math.max(i-k,0); p <= r; ++p)
                    mat[i][j] += result[p][c]-(j-(k+1) >= 0 ? result[p][j-(k+1)] : 0);
            }
        
        return mat;
    }
}