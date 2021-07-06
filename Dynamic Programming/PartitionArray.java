/*https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1*/

/*
If there are no elements in arr, answer will be false
If sum is 0, answer is true
For all other cases, the answer will be true
if it is either true by including the current element or by excluding it
*/

class Solution{
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for (int i = 0; i < N; ++i)
            sum += arr[i];
        if (sum%2 != 0) return 0;
        boolean[][] table = new boolean[(sum/2)+1][N+1];
        for (int i = 0; i <= sum/2; ++i)
            table[i][0] = false;
        for (int i = 0; i <= N; ++i)
            table[0][i] = true;
        for (int i = 1; i <= sum/2; ++i)
            for (int j = 1; j <= N; ++j)
                table[i][j] = table[i][j-1]||(i >= arr[j-1] ? table[i-arr[j-1]][j-1] : false);
        return table[sum/2][N] ? 1 : 0;
    }
}