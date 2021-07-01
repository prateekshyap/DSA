/*https://practice.geeksforgeeks.org/problems/coin-change2448/1/*/

class Solution
{
    public long count(int S[], int m, int n) 
    {
        long[] table = new long[n+1];
        table[0] = 1;
        for (int i = 0; i < m; ++i)
            for (int j = S[i]; j <= n; ++j)
                table[j] += table[j-S[i]];
        return table[n];
    }
}