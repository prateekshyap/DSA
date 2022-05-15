/*https://leetcode.com/problems/interleaving-string/*/

class Solution {
    int[][] dp;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length()+s2.length() != s3.length()) return false; //if lengths don't match, return false

        dp = new int[s1.length()+1][s2.length()+1]; //create a table for dynamic programming

        //store -1 everywhere
        for (int i = 0; i <= s1.length(); ++i)
        {
            for (int j = 0; j <= s2.length(); ++j)
            {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = recur(s1, s2, s3) ? 1 : 0; //call recursion with the original strings
        return dp[0][0] == 1 ? true : false; //return result
    }
    
    private boolean recur(String s1, String s2, String s3)
    {
        int m = s1.length(), n = s2.length(), l = s3.length(); //store lengths of the strings
        if (m+n != l) //if lengths don't match
        {
            dp[m][n] = 0; //store 0 at the position
            return false; //return false
        }
        if (s1.equals("") && s2.equals("") && s3.equals("")) //if all characters are checked
        {
            dp[0][0] = 1; //store 1 at the position
            return true; //return true
        }
        if (dp[m][n] >= 0) return dp[m][n] == 1 ? true : false; //if already calculated, return the result
        boolean result1 = false, result2 = false; //create two variables
        if (m > 0 && l > 0 && s1.charAt(m-1) == s3.charAt(l-1)) //if the last characters of s1 and s3 match
        {
            if (dp[m][n] == 0 || dp[m][n] == -1) dp[m][n] = recur(s1.substring(0,m-1),s2,s3.substring(0,l-1)) ? 1 : 0; //calculate and store the result in the table
            result1 = dp[m][n] == 1 ? true : false; //store in result1
        }
        if (n > 0 && l > 0 && s2.charAt(n-1) == s3.charAt(l-1)) //if the last characters of s2 and s3 match
        {
            if (dp[m][n] == 0 || dp[m][n] == -1) dp[m][n] = recur(s1,s2.substring(0,n-1),s3.substring(0,l-1)) ? 1 : 0; //calculate and store the result in the table
            result2 = dp[m][n] == 1 ? true : false; //store in result2
        }
        dp[m][n] = result1||result2 ? 1 : 0;
        return dp[m][n] == 1 ? true : false; //return result
    }
}