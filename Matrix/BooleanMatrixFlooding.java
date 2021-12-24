/*https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1*/

class Solution
{
    void booleanMatrix(int matrix[][])
    {
        boolean[] row = new boolean[matrix.length];
        boolean[] col = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[0].length; ++j)
            {
                if (matrix[i][j] == 1)
                {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < matrix.length; ++i)
        {
            for (int j = 0; j < matrix[0].length; ++j)
            {
                if (row[i] == true || col[j] == true)
                {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}