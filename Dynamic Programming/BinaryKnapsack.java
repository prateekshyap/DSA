/*https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1*/

class Solution 
{ 
    static int knapSack(int W, int wt[], int val[], int n) 
    {
        int[][] table = new int[n+1][W+1];
        for (int i = 1; i < n+1; ++i)
        {
            for (int j = 1; j < W+1; ++j)
            {
                if (wt[i-1] > j)
                    table[i][j] = table[i-1][j];
                else //maximum of including the current item and excluding the current item
                    table[i][j] = Math.max(val[i-1]+table[i-1][j-wt[i-1]],table[i-1][j]);
            }
        }
        return table[n][W];
    } 
}
