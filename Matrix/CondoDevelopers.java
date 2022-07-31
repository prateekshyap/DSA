/*https://binarysearch.com/problems/Condo-Developers*/

import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, i, j;
        int[] maxRow = new int[m], maxCol = new int[n];

        int max = 0;
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
                if (matrix[i][j] > maxRow[i])
                    maxRow[i] = matrix[i][j];
        }
        for (j = 0; j < n; ++j)
        {
            for (i = 0; i < m; ++i)
                if (matrix[i][j] > maxCol[j])
                    maxCol[j] = matrix[i][j];
        }
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                matrix[i][j] = Math.min(maxRow[i],maxCol[j]);
        return matrix;
    }
}

import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, i, j;
        int[] maxRow = new int[m], maxCol = new int[n];

        int max = 0;
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (matrix[i][j] > maxRow[i]) maxRow[i] = matrix[i][j];
                if (matrix[i][j] > maxCol[j]) maxCol[j] = matrix[i][j];
            }
        }
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                matrix[i][j] = Math.min(maxRow[i],maxCol[j]);
        return matrix;
    }
}