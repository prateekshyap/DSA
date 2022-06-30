/*https://practice.geeksforgeeks.org/problems/number-of-ways2552/1*/

class Solution{
    static long arrangeTiles(int N){
        // code here
        if (N <= 3) return 1;
        long[] dp = new long[N+1];
        dp[0] = dp[1] = dp[2] = dp[3] = 1;
        for (int i = 4; i <= N; ++i)
            dp[i] = dp[i-1]+dp[i-4];
        return dp[N];
    }
}