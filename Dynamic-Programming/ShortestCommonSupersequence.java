/*https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1/*/

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