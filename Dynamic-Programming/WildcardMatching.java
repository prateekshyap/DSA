/*https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1*/

class Solution
{
    int wildCard(String pattern, String str)
    {
        // Your code goes here
        int n = pattern.length(), m = str.length();
        boolean[][] table = new boolean[n+1][m+1];
        
        for (int i = 0; i <= n; ++i)
        {
            for (int j = 0; j <= m; ++j)
            {
                if (i == 0 && j == 0) table[i][j] = true;
                else if (i == 0) table[i][j] = false;
                else if (j == 0)
                {
                    if (pattern.charAt(i-1) == '*') table[i][j] = table[i-1][j];
                    else table[i][j] = false;
                }
                else if (pattern.charAt(i-1) == '?' || pattern.charAt(i-1) == str.charAt(j-1)) table[i][j] = table[i-1][j-1];
                else if (pattern.charAt(i-1) == '*') table[i][j] = table[i-1][j] || table[i][j-1];
                else table[i][j] = false;
            }
        }
        
        return table[n][m] ? 1 : 0;
    }
}