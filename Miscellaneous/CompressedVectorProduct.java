/*https://binarysearch.com/problems/Compressed-Vector-Product*/

import java.util.*;

class Solution {
    public int solve(int[] a, int[] b) {
        int m = a.length, n = b.length, i, j, countA = 0, countB = 0, result = 0, times = 0;
        i = j = -1;
        while (i < m && j < n)
        {
            if (countA == 0) { if (i+1 >= m) break; countA = a[++i]; ++i; }
            if (countB == 0) { if (j+1 >= n) break; countB = b[++j]; ++j; }
            times = Math.min(countA,countB);
            result += a[i]*b[j]*times; countA -= times; countB -= times;
        }
        return result;
    }
}