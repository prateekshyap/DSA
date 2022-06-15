/*https://binarysearch.com/problems/Bomber-Man*/

import java.util.*;

class Solution {
    public int solve(int[][] matrix) {
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        int i, j, m = matrix.length, n = matrix[0].length;
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (matrix[i][j] == 1)
                {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        int count = 0;
        for (i = 0; i < m; ++i)
        {
            if (rows.contains(i)) continue;
            for (j = 0; j < n; ++j)
            {
                if (!cols.contains(j))
                    ++count;
            }
        }
        return count;
    }
}