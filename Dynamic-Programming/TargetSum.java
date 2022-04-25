/*https://practice.geeksforgeeks.org/problems/target-sum-1626326450/1*/

class Solution
{
    static int findTargetSumWays(int[] A , int N, int target)
    {
        int sum=0;
        for (int i = 0; i < A.length; ++i)
            sum = sum+A[i];
            
        if (target < -1*sum || target > sum) 
            return 0;
            

        int[][] dp = new int[A.length+1][sum*2+1];
        dp[0][sum] = 1;
        for (int i = 1; i <= A.length; ++i)
        {
            for (int j = 0; j < sum*2+1 ; ++j)
            {
                if (j+A[i-1] < sum*2+1)
                    dp[i][j] = dp[i][j]+dp[i-1][j+A[i-1]];
                if (j-A[i-1] >= 0)
                    dp[i][j] = dp[i][j]+dp[i-1][j-A[i-1]];
            }
        }
        return dp[A.length][sum+target];
    }
}