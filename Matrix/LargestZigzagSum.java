/*https://practice.geeksforgeeks.org/problems/largest-zigzag-sequence5416/1*/

class Solution{
    static int zigzagSequence(int n, int M[][]){
        // code here
        int[][] result = new int[n][n];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                result[i][j] = M[i][j];
        for (int i = 0; i < n; ++i)
            result[n-1][i] = M[n-1][i];
        for (int i = n-2; i >= 1; --i)
        {
            for (int j = 0; j < n; ++j)
            {
                int maxColVal = Integer.MIN_VALUE;
                for (int k = 0; k < n; ++k)
                {
                    if (j != k)
                        maxColVal = Math.max(maxColVal,result[i+1][k]+M[i][j]);
                }
                result[i][j] = Math.max(result[i][j],maxColVal);
            }
        }
        int max = Integer.MIN_VALUE;
        for (int j = 0; j < n; ++j)
        {
            int maxColVal = Integer.MIN_VALUE;
            for (int k = 0; k < n; ++k)
            {
                if (j != k)
                    maxColVal = Math.max(maxColVal,result[1][k]+M[0][j]);
            }
            result[0][j] = Math.max(result[0][j],maxColVal);
            max = Math.max(result[0][j],max);
        }
        return max;
    }
}