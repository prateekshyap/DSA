/*https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1/*/

class Solution{
    static int maxGold(int n, int m, int M[][])
    {	//base case
        if (m == 1 && n == 1) return M[0][0];
        
        //traverse from the right most column and keep adding the maximum gold possible
        for (int j = m-2; j >= 1; --j)
        {
            for (int i = 0; i < n; ++i)
            {
                int max = M[i][j+1];
                if (i > 0) max = Math.max(M[i-1][j+1],max);
                if (i < n-1) max = Math.max(M[i+1][j+1],max);
                M[i][j] += max;
            }
        }

        //for the first column
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i)
        {
            int max = m > 1 ? M[i][1] : M[i][0];
            if (i > 0 && m > 1) max = Math.max(M[i-1][1],max);
            if (i < n-1 && m > 1) max = Math.max(M[i+1][1],max);
            M[i][0] += m > 1 ? max : 0;
            result = Math.max(result,M[i][0]);
        }
        return result;
    }
}