/*https://binarysearch.com/problems/Zero-Matrix*/

import java.util.*;

class Solution {
    public int[][] solve(int[][] matrix) {
        HashSet<Integer> rows = new HashSet<Integer>(), cols = new HashSet<Integer>();
        int i, j, m = matrix.length, n = matrix[0].length;

        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (matrix[i][j] == 0)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (rows.contains(i) || cols.contains(j))
                {
                    matrix[i][j] = 0;
                }
            }
        }

        return matrix;
    }
}