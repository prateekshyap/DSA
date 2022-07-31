/*https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/*/ 

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for (int i = dp.length-1; i >= 0; --i)
        {
            for (int j = dp[0].length-1; j >= 0; --j)
            {
                if (i == dp.length-1 && j == dp[0].length-1)
                    dp[i][j] = 0;
                else if (i == dp.length-1)
                    dp[i][j] = (int)s2.charAt(j)+dp[i][j+1];
                else if (j == dp[0].length-1)
                    dp[i][j] = (int)s1.charAt(i)+dp[i+1][j];
                else
                {
                    if (s1.charAt(i) == s2.charAt(j))
                        dp[i][j] = dp[i+1][j+1];
                    else dp[i][j] = Math.min((int)s1.charAt(i)+dp[i+1][j],(int)s2.charAt(j)+dp[i][j+1]);
                }
            }
        }
        
        return dp[0][0];
    }
}

class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int i, j, m = s1.length(), n = s2.length();
        for (i = m-1; i >= 0; --i)
            dp[i][n] = dp[i+1][n]+(int)s1.charAt(i);
        for (j = n-1; j >= 0; --j)
            dp[m][j] = dp[m][j+1]+(int)s2.charAt(j);
        for (i = m-1; i >= 0; --i)
        {
            for (j = n-1; j >= 0; --j)
            {
                if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i+1][j+1];
                else dp[i][j] = Math.min(dp[i+1][j]+(int)s1.charAt(i),dp[i][j+1]+(int)s2.charAt(j));
            }
        }
        return dp[0][0];
    }
}