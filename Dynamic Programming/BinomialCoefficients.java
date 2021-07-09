/*https://practice.geeksforgeeks.org/problems/ncr1019/1*/

/*nCr + nC(r+1) = (n+1)Cr*/

class Solution{
    static int nCr(int n, int r)
    {
        int[][] table = new int[n+1][r+1];
        for (int i = 1; i <= n; ++i)
            for (int j = 0; j <= r; ++j)
            {
                if (j == 0 || i == j) table[i][j] = 1;
                else table[i][j] = (table[i-1][j-1]+table[i-1][j])%1000000007;
            }
        return table[n][r];
    }
}

class Solution{
    static int nCr(int n, int r)
    {
        int[] table = new int[r+1];
        table[0] = 1;
        for (int i = 1; i <= n; ++i)
        {
            int[] newTable = new int[r+1];
            for (int j = 0; j <= r; ++j)
            {
                if (j == 0 || i == j) newTable[j] = 1;
                else newTable[j] = (table[j-1]+table[j])%1000000007;
            }
            table = newTable;
        }
        return table[r];
    }
}

/*For Permutation Coefficient:-
                        
                        P(n,k) = P(n-1,k)+k*P(n-1,k-1)
*/