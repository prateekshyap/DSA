/*https://leetcode.com/problems/count-sorted-vowel-strings/*/

class Solution {
    public int countVowelStrings(int n) {
        int nov = 5;
        int[][] dp = new int[n][nov];
        int i, j;
        for (i = 0; i < nov; ++i)
            dp[0][i] = 1;
        for (i = 1; i < n; ++i)
        {
            dp[i][0] = 1;
            for (j = 1; j < nov; ++j)
                dp[i][j] = dp[i][j-1]+dp[i-1][j];
        }
        int sum = 0;
        for (i = 0; i < nov; ++i)
            sum += dp[n-1][i];
        return sum;
    }
}