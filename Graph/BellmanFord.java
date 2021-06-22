/*https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1*/

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        int[] d = new int[n];
        for (int i = 1; i < n; ++i)
            d[i] = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; ++i)
            for (int[] edge : edges)
                if(d[edge[0]] != Integer.MAX_VALUE && d[edge[0]]+edge[2] < d[edge[1]])
                    d[edge[1]] = d[edge[0]]+edge[2];
        for (int[] edge : edges)
            if (d[edge[0]] != Integer.MAX_VALUE && d[edge[0]]+edge[2] < d[edge[1]])
                return 1;
        return 0;
    }
}