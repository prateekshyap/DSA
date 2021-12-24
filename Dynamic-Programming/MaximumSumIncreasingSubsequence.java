/*https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1*/

class Solution
{
    public int maxSumIS(int arr[], int n)  
    {
        int[] result = new int[n];
        for (int i = 0; i < n; ++i)
            result[i] = arr[i];
        for (int i = 1; i < n; ++i)
        {
            for (int j = 0; j < i; ++j)
            {
                if (arr[i] > arr[j] && result[i] < result[j]+arr[i])
                    result[i] = result[j]+arr[i];
            }
        }
        int max = result[0];
        for (int i = 1; i < n; ++i)
            max = Math.max(max, result[i]);
        return max;
    }
}