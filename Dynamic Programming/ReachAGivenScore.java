/*https://practice.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1*/

//coin change variation
class Geeks {
    public long count(int n) {
        long[] dp = new long[n+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int[] scores = new int[3];
        scores[0] = 3;
        scores[1] = 5;
        scores[2] = 10;
        for (int i = 0; i < scores.length; ++i)
            for (int j = scores[i]; j <= n; ++j)
                dp[j] += dp[j-scores[i]];
        return dp[n];
    }
}