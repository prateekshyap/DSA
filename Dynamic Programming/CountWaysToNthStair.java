/*https://practice.geeksforgeeks.org/problems/count-ways-to-reach-the-nth-stair-1587115620/1*/

class Solution
{
    int[] dp;
    int countWays(int n)
    {
        if (n <= 3) return n;
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        countOrders(n);
        return dp[n];
    }
    public int countOrders(int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (dp[n] > 0)
            return dp[n];
        dp[n] = (countOrders(n-1)+countOrders(n-2))%1000000007;
        return dp[n];
    }
}