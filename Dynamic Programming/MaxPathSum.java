/*https://practice.geeksforgeeks.org/problems/path-in-matrix3805/1*/

//bottom up approach
class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        if (N == 1) return Matrix[0][0];
        //for each row in reverse order
        for (int i = N-2; i >= 1; --i)
        {
            //find out the maximum possible value and add
            for (int j = 0; j < N; ++j)
            {
                int max = Integer.MIN_VALUE;
                if (j >= 1) max = Math.max(max,Matrix[i+1][j-1]);
                max = Math.max(max,Matrix[i+1][j]);
                if (j <= N-2) max = Math.max(max,Matrix[i+1][j+1]);
                Matrix[i][j] += max;
            }
        }

        //while calculating for the last row, store the result as well
        int result = Integer.MIN_VALUE;
        for (int j = 0; j < N; ++j)
        {
            int max = Integer.MIN_VALUE;
            if (j >= 1) max = Math.max(max,Matrix[1][j-1]);
            max = Math.max(max,Matrix[1][j]);
            if (j <= N-2) max = Math.max(max,Matrix[1][j+1]);
            Matrix[0][j] += max;
            result = Math.max(Matrix[0][j],result);
        }
        return result;
    }
}