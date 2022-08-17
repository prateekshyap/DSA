/*https://practice.geeksforgeeks.org/problems/wildcard-pattern-matching/1*/
/*https://leetcode.com/problems/wildcard-matching/*/

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

class Solution {
    int m, n;
    Boolean[][] table;
    public boolean isMatch(String s, String p) {
        m = s.length();
        n = p.length();
        table = new Boolean[m][n];
        return solve(s.toCharArray(),p.toCharArray(),m-1,n-1);
        // return table[m-1][n-1];
    }
    private boolean solve(char[] s, char[] p, int i, int j)
    {
        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) //pattern is over but string is still remaining
            return false;
        if (i < 0 && j >= 0) //string is over but pattern is still remaining
        {
            //only asterisks will be allowed in this case
            for (int k = 0; k <= j; ++k)
                if (p[k] != '*')
                    return false;
            return true;
        }
        if (table[i][j] != null) return table[i][j];
        if (s[i] == p[j] || p[j] == '?') return table[i][j] = solve(s,p,i-1,j-1); //single character matching
        if (p[j] == '*') return table[i][j] = solve(s,p,i-1,j)||solve(s,p,i,j-1); //either extend the * match or end * and start next match
        return table[i][j] = false;
    }
}