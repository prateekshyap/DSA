/*https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1*/

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        int[][] dp = new int[N-1][N-1];

        //store infinite everywhere
        for (int i = 0; i < N-1; ++i)
            for (int j = 0; j < N-1; ++j)
                dp[i][j] = Integer.MAX_VALUE;
        int len = 0;
        int start = 0, end = start+len;

        //for N-1 times
        for (int count = 1; count < N; ++count)
        {
        	//till the dimension list is exhausted
            while (start < N-1 && end < N-1)
            {
            	//no need to multiply the same matrix
                if (start == end)
                    dp[start][end] = 0;
                else
                {
                	//run from start till end
                    for (int k = start; k < end; ++k)

                    	//update the boundary
                        dp[start][end] = Math.min(dp[start][end],dp[start][k]+dp[k+1][end]+(arr[start]*arr[k+1]*arr[end+1]));
                }

                //increment
                ++start; ++end;
            }

            //increase length of matrices to be multiplied
            ++len; start = 0; end = start+len;
        }
        return dp[0][N-2];
    }
}