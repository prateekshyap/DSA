/*https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1*/

class Solution {
    int lps(String s) {
        int n = s.length();
        int[] dp = new int[n];
        int i = 0, j = 1;
        while (j < n)
        {
            if (s.charAt(i) == s.charAt(j))
            {
                dp[j] = i+1;
                ++j; ++i;
            }
            else
            {
                if (i == 0) ++j;
                else if (i == 1)
                {
                    i = 0;
                    dp[j] = 0;
                }
                else
                {
                    dp[j] = 0;
                    j = j-i+1;
                    i = 0;
                }
            }
        }
        return dp[n-1];
    }
}