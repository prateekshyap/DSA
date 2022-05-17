/*https://leetcode.com/problems/integer-break/*/

class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] table = new int[n+1];
        table[0]=table[1] = 1;
        table[2] = 1;
        table[3] = 2;
        int i, j, k;
        for (i = 4; i <= n; ++i)
        {
            for (j = i/2; j >= 1; --j)
            {
                k = i-j;
                if (j*k > table[i]) table[i] = j*k; //i = j+k
                if (j*table[k] > table[i]) table[i] = j*table[k]; // i = j+k1+k2+k3+...+km where k = k1+k2+k3+...+km
                if (table[j]*k > table[i]) table[i] = table[j]*k; // i = j1+j2+j3+...+jm+k where j = j1+j2+j3+...+jm
                if (table[j]*table[k] > table[i]) table[i] = table[j]*table[k]; // i = j1+j2+j3+...+jm+k1+k2+k3+...+kn where k = k1+k2+k3+...+kn and j = j1+j2+j3+...+jn
            }
        }
        return table[n];
    }
}

class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int[] table = new int[n+1];
        table[0]=table[1] = 1;
        table[2] = 1;
        table[3] = 2;
        int i, j, k;
        boolean isUpdated = false;
        for (i = 4; i <= n; ++i)
        {
            for (j = i/2; j >= 1; --j)
            {
                k = i-j;
                isUpdated = false;
                if (j*k > table[i])
                {
                    isUpdated = true;
                    table[i] = j*k;
                }
                if (j*table[k] > table[i])
                {
                    isUpdated = true;
                    table[i] = j*table[k];
                }
                if (table[j]*k > table[i])
                {
                    isUpdated = true;
                    table[i] = table[j]*k;
                }
                if (table[j]*table[k] > table[i])
                {
                    isUpdated = true;
                    table[i] = table[j]*table[k];
                }
                if (!isUpdated) break;
            }
        }
        return table[n];
    }
}