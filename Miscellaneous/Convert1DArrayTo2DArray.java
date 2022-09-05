/*https://leetcode.com/problems/convert-1d-array-into-2d-array/*/

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m*n != original.length) return new int[0][0];
        int[][] d2 = new int[m][n];
        int i = 0, j = 0;
        for (int num : original)
        {
            d2[i][j] = num;
            ++j;
            if (j == n)
            {
                ++i;
                j = 0;
            }
        }
        return d2;
    }
}