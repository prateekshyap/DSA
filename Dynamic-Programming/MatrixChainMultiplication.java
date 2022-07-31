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

class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        return solve(arr,0,N-2);
    }
    static int solve(int[] arr, int i, int j)
    {
        if (i == j) return 0;
        
        int result = Integer.MAX_VALUE, k;
        for (k = i; k < j; ++k)
            result = Math.min(result,solve(arr,i,k)+solve(arr,k+1,j)+(arr[i]*arr[k+1]*arr[j+1]));
        
        return result;
    }
}

class Solution{
    static Integer[][] costs;
    static int matrixMultiplication(int N, int arr[])
    {
        costs = new Integer[N-1][N-1];
        costs[0][N-2] = solve(arr,0,N-2);
        return costs[0][N-2];
    }
    static int solve(int[] arr, int i, int j)
    {
        if (i == j) return 0;
        if (costs[i][j] != null) return costs[i][j];
        int result = Integer.MAX_VALUE, k;
        for (k = i; k < j; ++k)
            result = Math.min(result,solve(arr,i,k)+solve(arr,k+1,j)+(arr[i]*arr[k+1]*arr[j+1]));
        costs[i][j] = result;
        return result;
    }
}

/*Recursion+Tabulation*/
class Solution{
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int i = 1,j = N-1;
        int dp[][] = new int[N][N];
        for(int m=0;m<N;m++)
        Arrays.fill(dp[m],Integer.MAX_VALUE);
        return solve(arr,i,j,dp);
    }
    static int solve(int arr[],int i,int j,int[][] dp)
    {
        if(i>=j)return 0;
        if(dp[i][j]!=Integer.MAX_VALUE)return dp[i][j];
        for(int k = i;k<j;k++)
        {
            dp[i][j] = Math.min(dp[i][j],solve(arr,i,k,dp)+solve(arr,k+1,j,dp)+arr[i-1]*arr[k]*arr[j]);
        }
        return dp[i][j];
    }
}