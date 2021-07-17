/*https://practice.geeksforgeeks.org/problems/number-of-coins1824/1*/

class Solution
{
	public int minCoins(int coins[], int M, int V) 
	{
	    HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();
	    for (int i = 0; i < M; ++i)
	        map.put(coins[i],true);
	        
	    //base case
        if (map.containsKey(V)) return 1;

        int dp[] = new int[V+1];

        for (int i = 1; i <= V; ++i)
        {
            dp[i] = Integer.MAX_VALUE;

            //for each coin check for the minimum count possible
            for (int j = 0; j < M; ++j)
                dp[i] = Math.min(dp[i], i-coins[j] >= 0 && dp[i-coins[j]] != Integer.MAX_VALUE ? 1+dp[i-coins[j]] : Integer.MAX_VALUE);
        }
        return dp[V] == Integer.MAX_VALUE ? -1 : dp[V];
	} 
}