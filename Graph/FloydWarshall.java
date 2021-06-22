/*https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1*/

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        for (int k = 0; k < matrix.length; ++k)
            for (int i = 0; i < matrix.length; ++i)
                for (int j = 0; j < matrix[0].length; ++j)
                {
                    if (matrix[i][k] == -1 || matrix[k][j] == -1) continue;
                    matrix[i][j] = matrix[i][j] == -1 ? matrix[i][k]+matrix[k][j] : Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]); 
                }
    }
}