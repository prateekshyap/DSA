/*https://practice.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1*/

/*unbounded knapsack variation (knapsack-with-duplicate-items4201 in GFG)*/
class Solution
{
	public int minimumCost(int cost[], int N,int W)
	{
        int[] dp = new int[W+1];
        for (int i = 1; i < dp.length; ++i) dp[i] = 1000000000;
        for (int i = 0; i <= W; ++i)
            for (int j = 0; j < N; ++j)
                if ((j+1) <= i && cost[j] != -1) dp[i] = Math.min(dp[i],dp[i-(j+1)]+cost[j]);
        return dp[W] == 1000000000 ? -1 : dp[W];
	}
}

/*rod cutting variation(cutted-segments1642 in GFG)*/
class Solution
{
    public int minimumCost(int cost[], int N,int W)
    {
        int[] table = new int[W+1];
        for (int i = 1; i <= W; ++i)
        {
            int min = 1000000000;
            for (int j = 0; j < Math.min(i,N); ++j)
                min = Math.min(min,((i-(j+1) == 0 || (i-(j+1) > 0 && table[i-(j+1)] > 0)) && cost[j] != -1 ? table[i-(j+1)]+cost[j] : 1000000000));
            table[i] = min;
        }
        return table[W] == 1000000000 ? -1 : table[W];
    }
}