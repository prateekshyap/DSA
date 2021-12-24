/*https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1#*/

//catalan numbers approach
class Solution
{
    static int numTrees(int N)
    {
        long[] dp = new long[N+1];
        dp[0] = 1;
        
        for(int i = 1; i <= N; i++)
        {
            for(int j = 0; j < i; j++)
            {
                long val = (dp[j] * dp[i-1-j])%1000000007;
                dp[i] = (dp[i] + val)%1000000007; 
            }
        }
        
        return (int)dp[N];
    }
}