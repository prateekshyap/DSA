/*https://leetcode.com/problems/rotate-image/*/

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1) return;
        
        //transposed
        for (int i = 0; i < matrix.length; ++i)
            for (int j = i+1; j < matrix[0].length; ++j)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        
        //flipped vertically
        int cs = 0, ce = matrix[0].length-1;
        while (cs < ce)
        {
            for (int i = 0; i < matrix.length; ++i)
            {
                int temp = matrix[i][cs];
                matrix[i][cs] = matrix[i][ce];
                matrix[i][ce] = temp;
            }
            ++cs; --ce;
        }
    }
}