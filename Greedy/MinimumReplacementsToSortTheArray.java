/*https://leetcode.com/problems/minimum-replacements-to-sort-the-array/*/

class Solution {
      public long minimumReplacement(int[] A) {
        long x = 1000000000, res = 0, k;
        for (int i = A.length - 1; i >= 0; --i) {
            if (A[i]%x == 0)
            {
                k = A[i]/x;
            }
            else
            {
                k = A[i]/x+1;
                x = A[i]/k;
            }
            res += k-1;
        }
        return res;
    }
}