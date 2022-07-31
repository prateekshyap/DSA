/*https://leetcode.com/problems/number-of-distinct-roll-sequences/*/

class Solution {
    int[][][] dp;
    public int distinctSequences(int n)
    {
        int i, j, k;
        dp = new int[7][7][n+1];
        for (i = 0; i < 7; ++i)
            for (j = 0; j < 7; ++j)
                for (k = 0; k < n+1; ++k)
                    dp[i][j][k] = -1;
        return recur(n,-1,-1,0);
    }
    
    public int recur(int n, int last, int secondLast, int in)
    {
        if (n == in) return 1;
        if (last != -1 && secondLast != -1 && dp[last][secondLast][in] != -1) return dp[last][secondLast][in];
        long result = 0;
        int i;
        for (i = 1; i <= 6; ++i)
        {
            if (i == last || i == secondLast || (last != -1 && !gcd(i,last))) continue;
            result += recur(n, i, last, in+1);
            result %= 1000000007;
        }
        if (last != -1 && secondLast != -1) dp[last][secondLast][in] = (int)result;
        return (int)result;
    }

    public boolean gcd(int i, int j)
    {
        if (i == 1 && (j == 2 || j == 3 || j == 4 || j == 5 || j == 6)) return true;
        if (i == 2 && (j == 1 || j == 3 || j == 5)) return true;
        if (i == 3 && (j == 1 || j == 2 || j == 4 || j == 5)) return true;
        if (i == 4 && (j == 1 || j == 3 || j == 5)) return true;
        if (i == 5 && (j == 1 || j == 2 || j == 3 || j == 4 || j == 6)) return true;
        if (i == 6 && (j == 1 || j == 5)) return true;
        return false;
    }
}