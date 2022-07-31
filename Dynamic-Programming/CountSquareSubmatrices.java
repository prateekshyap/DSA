/*https://binarysearch.com/problems/Count-Square-Submatrices*/

import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        int i, counter = 0, j, m = matrix.length, n= matrix[0].length, min;
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (matrix[i][j] == 1)
                {
                    min = 0;
                    if (i != 0 && j != 0) min = Math.min(matrix[i-1][j],Math.min(matrix[i][j-1],matrix[i-1][j-1]));
                    matrix[i][j] += min;
                    counter += matrix[i][j];
                }
            }
        }
        return counter;
    }
}