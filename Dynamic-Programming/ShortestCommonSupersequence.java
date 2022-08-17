/*https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1/*/
/*https://leetcode.com/problems/shortest-common-supersequence/*/

class Solution
{
    //Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String X,String Y,int m,int n)
    {
        //Your code here
        int i = 0, j = 0;
        int[][] table = new int[m+1][n+1];
        for (i = 1; i < m+1; ++i)
        {
            for (j = 1; j < n+1; ++j)
            {
                if (X.charAt(i-1) == Y.charAt(j-1))
                    table[i][j] = table[i-1][j-1]+1;
                else
                    table[i][j] = Math.max(table[i-1][j],table[i][j-1]);
            }
        }
        return X.length()+Y.length()-table[m][n];
    }
}

class Solution {
    public String shortestCommonSupersequence(String s1, String s2) {
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        int i, j;
        for (i = 1; i <= s1.length(); ++i)
        {
            for (j = 1; j <= s2.length(); ++j)
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
        StringBuilder result = new StringBuilder("");
        i = s1.length(); j = s2.length();
        while (i > 0 || j > 0)
        {
            if (i <= 0) result.insert(0,s2.charAt((j--)-1));
            else if (j <= 0) result.insert(0,s1.charAt((i--)-1));
            else if (s1.charAt(i-1) == s2.charAt(j-1))
            {
                result.insert(0,s1.charAt(i-1));
                --i; --j;
            }
            else if (dp[i-1][j] > dp[i][j-1])
                result.insert(0,s1.charAt((i--)-1));
            else result.insert(0,s2.charAt((j--)-1));
        }
        return result.toString();
    }
}