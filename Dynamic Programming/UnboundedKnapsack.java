/*https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1*/

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        /*
        We need to get the maximum of the current value at the cell
        and by adding the current item to the knapsack
        */
        int[] dp = new int[W+1];
        for (int i = 0; i <= W; ++i)
            for (int j = 0; j < N; ++j)
                if (wt[j] <= i) dp[i] = Math.max(dp[i],dp[i-wt[j]]+val[j]);
        return dp[W];
    }
}