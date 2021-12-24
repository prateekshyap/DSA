/*https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1*/

class Solution
{
    static int lcs(int x, int y, String s1, String s2)
    {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int i = 1; i <= s1.length(); ++i)
        {
            for (int j = 1; j <= s2.length(); ++j)
            {
            	//if equal, add one to the diagonally previous element
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1]+1;

                //otherwise store the maximum among the upper and left element
                else if (dp[i-1][j] > dp[i][j-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i][j-1];
            }
        }
        return dp[s1.length()][s2.length()];
    }   
}