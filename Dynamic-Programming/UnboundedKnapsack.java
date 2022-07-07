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

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[] table = new int[W+1];
        int index = 0;
        for (int i = 1; i <= N; ++i)
            for (int j = wt[i-1]; j <= W; ++j)
                table[j] = Math.max(val[i-1]+table[j-wt[i-1]],table[j]);
        return table[W];
    }
}

/*Pratik's Solution*/

class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int dp[][] = new int[N+1][W+1];
        return computeKS(N,W,val,wt,dp);
    }
    static int computeKS(int N,int W,int[] val,int[] wt,int[][] dp)
    {
        if(N==0||W==0)return 0;
        if(dp[N][W]!=0)return dp[N][W];
        if(wt[N-1]>W)
        {
            return dp[N][W] = computeKS(N-1,W,val,wt,dp);
        }
        else
        {
            return dp[N][W] = Math.max(
                computeKS(N-1,W,val,wt,dp),
                val[N-1]+computeKS(N,W-wt[N-1],val,wt,dp)
                );
        }
    }
}