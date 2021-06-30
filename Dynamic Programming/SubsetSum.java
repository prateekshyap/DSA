/*https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1*/

class Solution{
    static Boolean isSubsetSum(int n, int arr[], int sum){
        boolean[][] table = new boolean[n+1][sum+1];
        for (int i = 0; i < n+1; ++i)
            table[i][0] = true;
        for (int i = 1; i < n+1; ++i)
        {
            for (int j = 1; j < sum+1; ++j)
            {
                if (arr[i-1] > j)
                    table[i][j] = table[i-1][j];
                else //including the current element or excluding the current element
                    table[i][j] = table[i-1][j-arr[i-1]]||table[i-1][j];
            }
        }
        return table[n][sum];
    }
}