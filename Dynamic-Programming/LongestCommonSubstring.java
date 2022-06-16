/*https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1*/
/*https://binarysearch.com/problems/Longest-Common-Substring*/

/*
Modification of Longest Common Subsequence-
If the current characters are same
add 1 to the previous length
otherwise store 0
*/

class Solution{
    int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for (int i = 1; i < n+1; ++i)
            for (int j = 1; j < m+1; ++j)
                if (S1.charAt(i-1) == S2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                    max = Math.max(max,dp[i][j]);
                }
        return max;
    }
}