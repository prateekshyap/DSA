/*https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1*/
/*https://leetcode.com/problems/longest-common-subsequence/*/

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

class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        //return recur(text1,text2,text1.length()-1,text2.length()-1);
        int m = text1.length(), n = text2.length();
        dp = new Integer[m+1][n+1];
        dp[m][n] = recur(text1,text2);
        return dp[m][n];
    }
    public int recur(String text1, String text2)
    {
        int m = text1.length(), n = text2.length();
        if (text1.length() == 1 && text2.length() == 1)
        {
            if (text1.equals(text2))
                dp[m][n] = 1;
            else dp[m][n] = 0;
            return dp[m][n];
        }
        if (dp[m][n] != null) return dp[m][n];
        if (m == 0 || n == 0) return dp[0][0] = 0;
        if (text1.charAt(m-1) == text2.charAt(n-1))
            dp[m][n] = 1+recur(text1.substring(0,m-1),text2.substring(0,n-1));
        else
            dp[m][n] = Math.max(recur(text1.substring(0,m-1),text2),recur(text1,text2.substring(0,n-1)));
        return dp[m][n];
    }
}